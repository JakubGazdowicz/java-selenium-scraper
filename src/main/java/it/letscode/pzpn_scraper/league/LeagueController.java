package it.letscode.pzpn_scraper.league;

import it.letscode.pzpn_scraper.league.league_club_row.LeagueClubRow;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clubs")
public class LeagueController {
    private final LeagueService leagueService;

    @GetMapping
    public Page<LeagueClubRow> getAll(Pageable pageable) {
        return leagueService.getAll(pageable);
    }
}
