package it.letscode.pzpn_scraper;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScraperRunner implements CommandLineRunner {

    private final ScrapeService scrapeService;

    @Override
    public void run(String... args) throws Exception {
//        if("scape".equals(args[0])) {
            scrapeService.run();
//        }
    }
}
