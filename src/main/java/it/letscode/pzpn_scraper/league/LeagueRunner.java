package it.letscode.pzpn_scraper.league;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeagueRunner implements CommandLineRunner {

    private final LeagueService leagueService;

    @Override
    public void run(String... args) throws Exception {
        leagueService.run();
    }
}
