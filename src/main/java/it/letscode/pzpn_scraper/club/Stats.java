package it.letscode.pzpn_scraper.club;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {
    private Integer balanceGoalsCount;
    private Integer drawsCount;
    private Integer goalsCount;
    private Integer losesCount;
    private Integer lostGoalsCount;
    private Integer matchesCount;
    private Integer points;
    private Integer winsCount;
}
