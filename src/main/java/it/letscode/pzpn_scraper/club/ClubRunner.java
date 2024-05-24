package it.letscode.pzpn_scraper.club;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClubRunner implements CommandLineRunner {

    private final ClubService clubService;

    @Override
    public void run(String... args) throws Exception {
        clubService.run();
    }
}
