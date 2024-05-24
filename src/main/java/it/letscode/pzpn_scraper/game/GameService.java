package it.letscode.pzpn_scraper.game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Page<Game> getAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public List<Game> getByClubId(String id) {
        return gameRepository.getByGuest_guestIdOrHost_hostId(id, id);
    }
}
