package it.letscode.pzpn_scraper.league.league_club_row;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.letscode.pzpn_scraper.league.Stats;
import it.letscode.pzpn_scraper.league.Team;
import lombok.Data;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LeagueClubRow {
    @Id
    private String id;

    private Integer index;

    private String positionStatus;

    private String promotionStatus;

    private Stats stats;

    private Team team;
}
