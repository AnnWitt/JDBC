package KopieZadan.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Region {
    private String regionName;
    private Integer regionId;
    //nie dawac pokreslnikow w kodzie javowym bo to fujek, dzialac bedzie ale fujek
}



