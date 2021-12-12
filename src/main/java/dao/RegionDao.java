package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.models.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class RegionDao {
    private Connection connection;

    public Region getRegionByID(Integer regionID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from regions where region_id= ?");
        preparedStatement.setInt(1, regionID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == true) { //dzieki temu null jak
            String regionNameFromDB = resultSet.getString("Region_name");
            Integer regionIDfromDB = resultSet.getInt("region_id");
            Region reg = new Region(regionNameFromDB, regionIDfromDB);
            return reg;
        }
        return null;
    }

    public List<Region> getAllRegions() throws SQLException {
        List<Region> regions = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT REGION_ID, REGION_NAME FROM REGIONS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int region_id = resultSet.getInt("REGION_ID");
            String region_name = resultSet.getString("REGION_NAME");
            Region region = new Region(region_name, region_id);
            regions.add(region);
        }
        preparedStatement.close();
        return regions;
    }


    public void delete(Integer regionID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from regions where region_id= ?");
        preparedStatement.setInt(1, regionID);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateRegion(Region region) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Update regions set region_name= ? where region_id= ?");
        preparedStatement.setString(1, region.getRegionName());
        preparedStatement.setInt(2, region.getRegionId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void transactionTEST(String name1, String name2) {
        try {
            connection.setAutoCommit(false); //przez tp się nie zapisuje, wymaga potwierdzenia
            PreparedStatement pr = connection.prepareStatement("Update regions set region_name=? where region_id=3");
            pr.setString(1, name1);
            pr.executeUpdate();
            PreparedStatement pr2 = connection.prepareStatement("Update regions set region_name=? where region_id=4");
            pr2.setString(1, name2);
            pr.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        // connection.commit(); //tu idzie commit )calosci
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//wez to zrobv tak jak bylo z normalnym wyjatkiem

       // pr.close();

        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}