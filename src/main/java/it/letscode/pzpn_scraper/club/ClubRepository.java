package it.letscode.pzpn_scraper.club;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClubRepository extends MongoRepository<Club, String> {
}
