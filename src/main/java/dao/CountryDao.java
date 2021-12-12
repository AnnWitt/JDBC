package dao;

import lombok.AllArgsConstructor;
import org.example.models.Country;
import org.example.models.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CountryDao {
    private Connection connection;

    public Country getCoutryByID(String countryID) throws SQLException {
        PreparedStatement preparedStatementCountry = connection.prepareStatement("Select * from countries where country_id=?");
        preparedStatementCountry.setString(1, countryID); //1 bo parametr z zapytania
        ResultSet wynik = preparedStatementCountry.executeQuery();
        wynik.next();
        if (wynik.next() == true) {
            String country_idDB = wynik.getString("country_id");
            String country_nameDB = wynik.getString("country_name");
            Integer region_idDB = wynik.getInt("region_id");
            Country kraj = new Country(country_idDB, country_nameDB, region_idDB);
            return kraj;
        }
        return null;
    }


    public List<Country> getAllCountries() throws SQLException {
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

    public void delete (String countryID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from countries where country_id=?");
        preparedStatement.setString(1, countryID);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateCounty (Country country) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update countries set country_name =? where country_id=?");
        preparedStatement.setString(1,country.getCountry_name());
        preparedStatement.setString(2,country.getCountry_id());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
