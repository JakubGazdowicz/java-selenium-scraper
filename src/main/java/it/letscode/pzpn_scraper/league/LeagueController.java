package it.letscode.pzpn_scraper.league;

import it.letscode.pzpn_scraper.league.league_club_row.LeagueClubRow;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leagues")
@AllArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;

    @GetMapping
    public Page<League> getAll(Pageable pageable) {
        return leagueService.getAll(pageable);
    }
}
