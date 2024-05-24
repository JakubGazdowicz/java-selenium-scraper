package it.letscode.pzpn_scraper.league;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public Page<League> getAll(Pageable pageable) {
        return leagueRepository.findAll(pageable);
    }
}
