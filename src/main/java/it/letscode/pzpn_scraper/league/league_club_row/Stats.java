package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {

    @JsonProperty
    private Integer balanceGoalsCount;

    @JsonProperty
    private Integer drawsCount;

    @JsonProperty
    private Integer goalsCount;

    @JsonProperty
    private Integer losesCount;

    @JsonProperty
    private Integer lostGoalsCount;

    @JsonProperty
    private Integer matchesCount;

    @JsonProperty
    private Integer points;

    @JsonProperty
    private Integer winsCount;
}
