package it.letscode.pzpn_scraper.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.letscode.pzpn_scraper.league.league_club_row.LeagueClubRow;
import it.letscode.pzpn_scraper.league.league_club_row.LeagueJson;
import it.letscode.pzpn_scraper.league.league_club_row.Play;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
    @Id
    private String id;

    private LeagueJson league;

    private Play play;

    private List<LeagueClubRow> rows;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
