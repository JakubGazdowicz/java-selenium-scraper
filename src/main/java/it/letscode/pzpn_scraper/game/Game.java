package it.letscode.pzpn_scraper.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Game {
    @Id
    private String id;

    private Boolean canDateTimeChange;

    private String dateTime;

    private Guest guest;

    private Host host;

    private String matchId;

    private Integer queue;

    private Scores scores;

    private String stadium;

    private String state;
}
