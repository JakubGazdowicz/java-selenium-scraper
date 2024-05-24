package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Team {

    @JsonProperty
    private String abbreviation;

    @JsonProperty(value = "id")
    private String teamId;

    @JsonProperty
    private String logo;

    @JsonProperty
    private String name;
}
