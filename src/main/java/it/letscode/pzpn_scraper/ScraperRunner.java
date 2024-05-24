package it.letscode.pzpn_scraper;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScraperRunner implements CommandLineRunner {

    private final ScrapeService leagueService;

    @Override
    public void run(String... args) throws Exception {
        leagueService.run();
    }
}
