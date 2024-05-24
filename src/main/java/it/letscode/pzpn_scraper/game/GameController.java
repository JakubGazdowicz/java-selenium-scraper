package it.letscode.pzpn_scraper.game;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public Page<Game> getAll(Pageable pageable) {
        return gameService.getAll(pageable);
    }

    @QueryMapping("games")
    public List<Game> getByClubId(@Argument String clubId) {
        return gameService.getByClubId(clubId);
    }
}
