package it.letscode.pzpn_scraper.league;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/leagues")
@AllArgsConstructor
public class LeagueController {

    private final LeagueService leagueService;

    @GetMapping
//    @QueryMapping("leagues")
    public Page<League> getAll(Pageable pageable) {
        return leagueService.getAll(pageable);
    }

    @QueryMapping("league")
    public Optional<League> getById(@Argument String id) {
        return leagueService.getById(id);
    }


}
