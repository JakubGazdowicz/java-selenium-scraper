package it.letscode.pzpn_scraper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sudharsan_selvaraj.wowxhr.WowXHR;
import io.github.sudharsan_selvaraj.wowxhr.exceptions.DriverNotSupportedException;
import io.github.sudharsan_selvaraj.wowxhr.log.XHRLog;
import it.letscode.pzpn_scraper.game.Game;
import it.letscode.pzpn_scraper.game.GameRepository;
import it.letscode.pzpn_scraper.league.League;
import it.letscode.pzpn_scraper.league.LeagueRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScrapeService {
     private WowXHR wowXhr;

    private final List<XHRLog> xhrLogs = new ArrayList<>();

     private final LeagueRepository leagueRepository;
     private final GameRepository gameRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public ScrapeService(LeagueRepository leagueRepository, GameRepository gameRepository) {
        this.leagueRepository = leagueRepository;
        this.gameRepository = gameRepository;
    }

    public void run() throws DriverNotSupportedException, JsonProcessingException, InterruptedException {
        WebDriver driver = setupWebDriver();

        driver.get("https://www.laczynaspilka.pl/rozgrywki?season=2023%2F2024&leagueGroup=63e0b91e-f2cc-4149-813b-ea9a77919385&leagueId=20505afb-3cb6-4e59-9bb1-ed56e8201bb8&subLeague=733f5b9c-9ade-4011-84c4-b08d35d170b3&enumType=ZpnAndLeagueAndPlay&group=da03855e-6763-4671-b8ed-9b4aa7b10f0f&voivodeship=cd81a30b-c8a3-44e0-abd6-8b5772d3137c&isAdvanceMode=false&genderType=Male");

        League league = getClubsFromRequest();
        upsertLeague(league);

        List<Game> games = getGamesFromRequest();
        saveGamesToDatabase(games);
    }

    public void upsertLeague(League newLeague) {
        Optional<League> existingLeagueOpt = leagueRepository.findByPlay_PlayId(newLeague.getPlay().getPlayId());

        if (existingLeagueOpt.isPresent()) {
            League existingLeague = existingLeagueOpt.get();
            existingLeague.setLeague(newLeague.getLeague());
            existingLeague.setPlay(newLeague.getPlay());
            existingLeague.setRows(newLeague.getRows());
            // Zaktualizuj inne pola, jeśli istnieją
            leagueRepository.save(existingLeague);
        } else {
            leagueRepository.save(newLeague);
        }
    }

    private void saveGamesToDatabase(List<Game> games) {
        gameRepository.deleteAll();
        gameRepository.saveAll(games);
    }


    /////////////////////////////////////////////////////

    private JsonNode waitForClubResponse() throws JsonProcessingException {
        return waitForResponse("/tables");
    }

    private League getClubsFromRequest() throws JsonProcessingException, InterruptedException {
        JsonNode jsonNode = null;

        while(jsonNode == null) {
            Thread.sleep(1000);
            System.out.println("------ Waiting for clubs ------");
            jsonNode = waitForClubResponse();
        }

        System.out.println("Clubs set.");

        return objectMapper.readValue(jsonNode.toString(), new TypeReference<>() {});
    }

    ///////////////////////////////////////////////////////
    private JsonNode waitForGamesResponse() throws JsonProcessingException {
        return waitForResponse("/matches");
    }

    private List<Game> getGamesFromRequest() throws JsonProcessingException, InterruptedException {
        JsonNode jsonNode = null;

        while(jsonNode == null) {
            Thread.sleep(1000);
            System.out.println("------ Waiting for games ------");
            jsonNode = waitForGamesResponse();
        }

        System.out.println("Games set.");

        return objectMapper.readValue(jsonNode.toString(), new TypeReference<>() {});
    }

    ///////////////////////////////

    private JsonNode waitForResponse(String routePhrase) throws JsonProcessingException {

        List<XHRLog> logs = wowXhr.log().getXHRLogs();

        xhrLogs.addAll(logs);

        for(XHRLog log: xhrLogs) {
            String url = log.getRequest().getUrl();

            if(url != null && url.endsWith(routePhrase)) {
                String responseBody = (String) log.getResponse().getBody();

                return objectMapper.readTree(responseBody);
            }
        }

        return null;
    }

    private WebDriver setupWebDriver() throws DriverNotSupportedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        wowXhr = new WowXHR(webDriver);

        return wowXhr.getMockDriver();
    }

}
