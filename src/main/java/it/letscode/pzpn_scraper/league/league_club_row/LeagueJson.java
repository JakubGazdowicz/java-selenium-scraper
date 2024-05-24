package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeagueJson {

    @JsonProperty(value = "id")
    private String leagueId;

    @JsonProperty
    private String name;
}
