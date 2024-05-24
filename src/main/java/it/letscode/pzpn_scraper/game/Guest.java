package it.letscode.pzpn_scraper.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guest {
    private String abbreviation;

    private String id;

    private String name;
}
