package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Setter
public class Region {
    private String regionName;
    private Integer regionId;
    //nie dawac pokreslnikow w kodzie javowym bo to fujek, dzialac bedzie ale fujek
}



