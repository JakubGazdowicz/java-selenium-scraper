package it.letscode.pzpn_scraper.game;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {

    Game findByMatchId(String matchId);

    List<Game> getByGuest_guestIdOrHost_hostId(String guestId, String hostId);
}
