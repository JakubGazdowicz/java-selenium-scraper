package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LeagueClubRow {

    private Integer index;

    private String positionStatus;

    private String promotionStatus;

    private Stats stats;

    private Team team;
}
