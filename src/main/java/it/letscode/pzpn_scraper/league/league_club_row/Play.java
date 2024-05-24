package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Play {

    @JsonProperty(value = "id")
    private String playId;

    @JsonProperty
    private String name;
}
