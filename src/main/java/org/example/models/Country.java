package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

    @Getter
    @AllArgsConstructor
    @ToString
    @Setter
    public class Country {
        private String country_id;
        private String country_name;
        private Integer region_id;
        //nie dawac pokreslnikow w kodzie javowym bo to fujek, dzialac bedzie ale fujek
    }


