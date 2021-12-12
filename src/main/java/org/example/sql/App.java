package org.example.sql;


import dao.CountryDao;
import dao.RegionDao;
import lombok.ToString;
import org.example.ConnectionManager;
import org.example.DbCreator;
import org.example.models.Country;
import org.example.models.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
/*
        DbCreator dbCreator = new DbCreator();
dbCreator.createAndLoadData();
katalog db-data*/
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();


        System.out.println("---------");
        System.out.println("getAllRegions");
        RegionDao regionDao = new RegionDao(connection); //wzorzec projektowy fasada (kryjemy wszystko zw z tematem w jednym interfejsie
        Region regionByID = regionDao.getRegionByID(3);
        System.out.println(regionByID);
        System.out.println(regionDao.getAllRegions());

        System.out.println("------");
        System.out.println("po id");
        System.out.println("Country ID po NL");
        System.out.println("====");
        CountryDao countryDao = new CountryDao(connection);
        Country countryByID = countryDao.getCoutryByID("NL");
        System.out.println(countryByID);
        System.out.println("====");

        System.out.println("------remove region id =2 ");
        regionDao.delete(2);
        regionDao.getAllRegions().forEach(System.out::println);

        System.out.println("getAllCountries");
        countryDao.delete("ZW");
        countryDao.getAllCountries().forEach(System.out::println);


        System.out.println("-------------uppp---------");
        Region region3=regionDao.getRegionByID(3);
        region3.setRegionName("Blaa-aa");
        //System.out.println(region3); zawieszony "w prozni" - nie za[osze dpo bazy
        regionDao.updateRegion(region3); //zapisze do bazy
        regionDao.getAllRegions().forEach(System.out::println);


        System.out.println("------countries-----");
        Country countryX=countryDao.getCoutryByID("UK");
        countryX.setCountry_name("Blaaa UK");
        countryDao.updateCounty(countryX);
        countryDao.getAllCountries().forEach(System.out::println);
    }
}

