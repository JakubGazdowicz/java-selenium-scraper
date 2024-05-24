package it.letscode.pzpn_scraper.club;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sudharsan_selvaraj.wowxhr.WowXHR;
import io.github.sudharsan_selvaraj.wowxhr.exceptions.DriverNotSupportedException;
import io.github.sudharsan_selvaraj.wowxhr.log.XHRLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ClubService {
     private WowXHR wowXhr;

    public void run() throws DriverNotSupportedException, JsonProcessingException, InterruptedException {
        WebDriver driver = setupWebDriver();

        driver.get("https://www.laczynaspilka.pl/rozgrywki?season=2023%2F2024&leagueGroup=63e0b91e-f2cc-4149-813b-ea9a77919385&leagueId=20505afb-3cb6-4e59-9bb1-ed56e8201bb8&subLeague=733f5b9c-9ade-4011-84c4-b08d35d170b3&enumType=ZpnAndLeagueAndPlay&group=da03855e-6763-4671-b8ed-9b4aa7b10f0f&voivodeship=cd81a30b-c8a3-44e0-abd6-8b5772d3137c&isAdvanceMode=false&genderType=Male");

        Thread.sleep(20000);

        List<XHRLog> logs = wowXhr.log().getXHRLogs();

        for(XHRLog log: logs) {
            String url = log.getRequest().getUrl();

            if(url != null && url.endsWith("/tables")) {
                String responseBody = (String) log.getResponse().getBody();
                System.out.println(responseBody);
                System.out.println("--------------------------------");

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                JsonNode rows = jsonNode.get("rows");

                List<Club> clubs = objectMapper.readValue(rows.toString(), new TypeReference<>() {});

                for (Club club: clubs) {
                    System.out.println(club);
                    System.out.println(club.getStats().getPoints());
                    System.out.println("--------------------------------");
                }

                break;

            }
        }
    }

    private WebDriver setupWebDriver() throws DriverNotSupportedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        wowXhr = new WowXHR(webDriver);

        return wowXhr.getMockDriver();
    }
}
