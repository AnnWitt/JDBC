package KopieZadan.sql;


import org.example.ConnectionManager;
import org.example.models.Country;
import org.example.models.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        System.out.println("getAllRegions");
        System.out.println(getAllRegions(connection));
        System.out.println("getAllCountries");
        System.out.println(getAllCountries(connection));
        System.out.println("po id");
        Region regionID = getRegionByID(connection, 2);
        System.out.println(regionID);
        System.out.println("Country ID po NL");
        Country countryID = getCoutryByID(connection, "NL");
        System.out.println(countryID);

       /* PreparedStatement countriesPrepareStatement = connection.prepareStatement("SELECT * FROM COUNTRIES");
        ResultSet countiesResultSet = countriesPrepareStatement.executeQuery();
        while (countiesResultSet.next()) {
            String country_id = countiesResultSet.getString("COUNTRY_ID");
            String country_name = countiesResultSet.getString("COUNTRY_NAME");
            int region_id = countiesResultSet.getInt("REGION_ID");
            System.out.println(country_id + " " + country_name + " " + region_id);
        }
*/
        //TBD
        connection.close();
    }

    private static Country getCoutryByID(Connection connection, String countryID) throws SQLException {
        PreparedStatement preparedStatementCountry = connection.prepareStatement("Select * from countries where country_id=?");
        preparedStatementCountry.setString(1, countryID); //1 bo parametr z zapytania
        ResultSet wynik = preparedStatementCountry.executeQuery();
        wynik.next();
        String country_idDB = wynik.getString("country_id");
        String country_nameDB = wynik.getString("country_name");
        Integer region_idDB = wynik.getInt("region_id");
        Country kraj = new Country(country_idDB, country_nameDB, region_idDB);
        return kraj;
    }

    private static Region getRegionByID(Connection connection, Integer regionID) throws SQLException {
        //Lepiej nie bo + miedzy stringami może być injection
        // connection.prepareStatement("Select * from region where region_id= " + regionID);
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from regions where region_id= ?");//znak zapytaania oznacza, że cos bedzie
//zabezpieczenie, tu nie wejdzie injection
        preparedStatement.setInt(1, regionID); //parametr, [pierwszy znak zapytania w Seleccie
        //kolejne byłyby np 2, "test" , 3 4 , itd itd
        ResultSet resultSet = preparedStatement.executeQuery();
        //while niepotrzebny tu bo bedzie jeden wynik
        resultSet.next();
        String regionNameFromDB = resultSet.getString("Region_name");
        Integer regionIDfromDB = resultSet.getInt("region_id");
        Region reg = new Region(regionNameFromDB, regionIDfromDB);
        return reg;
    }


    public static List<Region> getAllRegions(Connection connection) throws SQLException {
        List<Region> regions = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT REGION_ID, REGION_NAME FROM REGIONS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int region_id = resultSet.getInt("REGION_ID");
            String region_name = resultSet.getString("REGION_NAME");
//            System.out.println("regionid: " + region_id + " regionname: " + region_name);
            Region region = new Region(region_name, region_id);
            regions.add(region);
        }
        preparedStatement.close();
        return regions;
    }

    public static List<Country> getAllCountries(Connection connection) throws SQLException {
        List<Country> countryList = new ArrayList<>();
        PreparedStatement countriesPrepareStatement = connection.prepareStatement("SELECT * FROM COUNTRIES");
        ResultSet countiesResultSet = countriesPrepareStatement.executeQuery();
        while (countiesResultSet.next()) {
            String country_id = countiesResultSet.getString("COUNTRY_ID");
            String country_name = countiesResultSet.getString("COUNTRY_NAME");
            int region_id = countiesResultSet.getInt("REGION_ID");
            Country country = new Country(country_id, country_name, region_id);
            countryList.add(country);
        }
        return countryList;
    }
}

