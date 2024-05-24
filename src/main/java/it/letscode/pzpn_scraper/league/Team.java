package it.letscode.pzpn_scraper.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Team {
    private String abbreviation;

    private String id;

    private String logo;

    private String name;
}
