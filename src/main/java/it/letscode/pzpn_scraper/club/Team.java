package it.letscode.pzpn_scraper.club;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private String abbreviation;

    private String id;

    private String logo;

    private String name;
}
