package it.letscode.pzpn_scraper.club;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Club {

    private Integer index;

    private String positionStatus;

    private String promotionStatus;

    private Stats stats;

    private Team team;
}
