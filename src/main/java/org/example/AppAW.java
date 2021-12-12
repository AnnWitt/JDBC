/*package org.example;

import org.example.models.Region;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppAW {
    public static void main(String[] args) throws Exception {
       *//* DbCreator dbCreator = new DbCreator();
        dbCreator.createAndLoadData();*//*
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();*/
        //od Region class
     /*  List<Region> regions = new ArrayList<>();

        //Statement statement = connection.createStatement();
        // statement.execute("Select * frp,");   //zwroxci tylko booleana T/F

        PreparedStatement preparedStatement2 = connection.prepareStatement("Select country_id, country_name, region_id from countries");



        PreparedStatement preparedStatement = connection.prepareStatement("Select region_id,region_name         from regions");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();

        //ResultSet testjoinSet = testjoin.executeQuery();
        while (resultSet.next()) {
    *//*        resultSet.getInt(1);
            resultSet.getString(2);*//*
            //indeksy niezbyt bezoieczne bo ktos moze cos pozmieniac w tabeli
            int region_id = resultSet.getInt("REGION_ID");
            String region_name = resultSet.getString("region_name");
            Region region=new Region(region_name, region_id);
            regions.add(region);
           // System.out.println("Region id " + region_id + " region name " + region_name);
        }
        //ctr alt n
        regions.forEach(System.out::println);*/
/*
        while (resultSet2.next()) {
            String country_id = resultSet2.getString("country_id");
            String country_name = resultSet2.getString("country_name");
            int region_id2 = resultSet2.getInt("region_id");
            System.out.println(" country id " + country_id + " country name " + country_name + " regiond id " + region_id2);
        }*/
//prepare statemetn


        //System.out.println("Ani komgbinowanie z joinami, ktre nie dziala :) ");


/*        while (resultSet2.next()) {
            String country_id = resultSet2.getString("country_id");
            String country_name = resultSet2.getString("country_name");
            String region_id2t = resultSet2.getString("region_name");
            int region_idt = resultSet.getInt("REGION_ID");
            System.out.println(" country id " + country_id + " country name " + country_name + " regiond id " + region_id2t + " test " + region_idt);


            //skrot na zmienna alt enter


            //zwroci wynik zapytania w postaci result setu, cos jak hashmapa,         lista kolejek, update jezeli zmieniac dane


            //TBD to be done
            //statement.close();
            connection.close();
        }
    }
    //tu funkcje
    public static List<Region> getAllRegions(Connection connection) {
        List<Region> regions = new ArrayList<>();

        //Statement statement = connection.createStatement();
        // statement.execute("Select * frp,");   //zwroxci tylko booleana T/F

        PreparedStatement preparedStatement2 = connection.prepareStatement("Select country_id, country_name, region_id from countries");
        PreparedStatement testjoin = connection.prepareStatement("Select c.country_id, c.country_name, c.region_id, r.region_id,r.region_name from countries c,regions r where c.region_id=r.region_id");


        PreparedStatement preparedStatement = connection.prepareStatement("Select region_id,region_name         from regions");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();*/

        //ResultSet testjoinSet = testjoin.executeQuery();
/*

        public static List<Region> getAllRegions (Connection connection){
            List<Region> regions = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("Select region_id,region_name         from regions");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int region_id = resultSet.getInt("REGION_ID");
                String region_name = resultSet.getString("region_name");
                Region region = new Region(region_name, region_id);
                regions.add(region);
                preparedStatement.close(); //zawsze samemu zamknac bo sie moe cos nie zapisac
            }
            //ctr alt n
            //regions.forEach(System.out::println);
        }
    }
}
*/
