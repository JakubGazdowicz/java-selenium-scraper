package it.letscode.pzpn_scraper.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scores {
    @JsonProperty(value = "final")
    private String finalScore;

    private String fullTime;

    private String half;
}
