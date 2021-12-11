package org.example;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
       /* DbCreator dbCreator = new DbCreator();
        dbCreator.createAndLoadData();*/
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        //Statement statement = connection.createStatement();
        // statement.execute("Select * frp,");   //zwroxci tylko booleana T/F
        PreparedStatement preparedStatement = connection.prepareStatement("Select region_id,region_name         from regions");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()) {
    /*        resultSet.getInt(1);
            resultSet.getString(2);*/
            //indeksy niezbyt bezoieczne bo ktos moze cos pozmieniac w tabeli
            int region_id = resultSet.getInt("REGION_ID");
            String region_name = resultSet.getString("region_name");
            System.out.println("Region id " + region_id + " regionname " + region_name);
        }

        //skrot na zmienna alt enter


        //zwroci wynik zapytania w postaci result setu, cos jak hashmapa,         lista kolejek, update jezeli zmieniac dane



        //TBD to be done
        //statement.close();
        connection.close();
    }
}
