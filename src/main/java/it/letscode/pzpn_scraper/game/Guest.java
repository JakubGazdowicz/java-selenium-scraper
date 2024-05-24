package it.letscode.pzpn_scraper.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guest {
    private String abbreviation;

    @JsonProperty(value = "id")
    private String guestId;

    private String logo;

    private String name;
}
