package it.letscode.pzpn_scraper.league;

import it.letscode.pzpn_scraper.league.league_club_row.LeagueClubRow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface LeagueRepository extends MongoRepository<League, String> {
    Optional<League> findByPlay_PlayId(String playId);
}
