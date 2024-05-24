package it.letscode.pzpn_scraper.club;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClubRepository extends MongoRepository<Club, String> {
}
