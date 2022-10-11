package org.example.service;

import org.example.model.City;
import org.example.model.CityMayor;
import org.example.model.Country;
import org.example.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Services {
    public static void createTableCities(){
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()){
            String SQL ="CREATE TABLE IF NOT EXISTS cities "+
                    "( id INTEGER  NOT NULL,"+
                    "name VARCHAR(55) NOT NULL,"+
                    "areaOfTheTerritory INTEGER NOT NULL)";

            statement.executeUpdate(SQL);
            System.out.println("Table is successfully created");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addCities(int id, String name,  int areaOfTheTerritory) throws SQLException {
        String SQL = "insert into cities (id , name ,areaOfTheTerritory  ) values (?,?,?)" ;
        Connection connection = Database.connection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,areaOfTheTerritory);
        statement.executeUpdate();
        System.out.println("Successfully added : " + name);
        connection.close();
    }

    public static void createTableCountries(){
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()){
            String SQL = "CREATE TABLE IF NOT EXISTS countries"+
                    "( id INTEGER NOT NULL," +
                    "name VARCHAR(55) NOT NULL," +
                    "capital VARCHAR(55) NOT NULL)";
            statement.executeUpdate(SQL);
            System.out.println("Table is successfully created");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addCountries(int id, String name, String capital) throws SQLException {
        String SQL = "insert into countries(id, name, capital) values(?,?,?) ";
        Connection connection = Database.connection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,capital);
        statement.executeUpdate();
        System.out.println("Successfully added : " + name);
        connection.close();

    }

    public static void createTableMayors(){
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()){
            String SQL = "CREATE TABLE IF NOT EXISTS mayors" +
                    "(id INTEGER NOT NULL," +
                    "name VARCHAR (55)NOT NULL)";
            statement.executeUpdate(SQL);
            System.out.println("Table is successfully created");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void addMayors(int id, String name) throws SQLException {
        String SQL = "insert into mayors (id, name) values (?,?)";
        Connection connection = Database.connection();
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setInt(1, id);
        statement.setString(2,name);
        statement.executeUpdate();
        System.out.println("Successfully added : " + name);
        connection.close();
    }

public static List<City> getCities(){
        String sql = "SELECT * FROM cities";
        List<City> cityList = new ArrayList<>();
        try (Connection connection = Database.connection();
        Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql))
        {
             while (resultSet.next()){
                 City city = new City();
                 city.setId(resultSet.getInt("id"));
                 city.setName(resultSet.getString("name"));
                 city.setAreaOfTheTerritory(resultSet.getInt("areaoftheterritory"));
                 cityList.add(city);
             }
        }catch (SQLException e){
             e.printStackTrace();
        }
        return cityList;
}
public static List<Country> getCountry(){
        String sql = "SELECT * FROM countries";
        List<Country> countryList = new ArrayList<>();
        try (Connection connection = Database.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCapital(resultSet.getString("capital"));
                countryList.add(country);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return countryList;
}
public static List<CityMayor> getMayor(){
        String sql = "SELECT * FROM mayors";
        List<CityMayor> cityMayorList = new ArrayList<>();
        try (Connection connection = Database.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql))
        {
            while (resultSet.next()){
                CityMayor cityMayor = new CityMayor();
                cityMayor.setId(resultSet.getInt("id"));
                cityMayor.setName(resultSet.getString("name"));
                cityMayorList.add(cityMayor);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cityMayorList;
}
public static void getCityByID(int id)throws IndexOutOfBoundsException{
        City[] cities = getCities().toArray(new City[0]);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
    for (City city: cities) {
        integerArrayList.add(city.getId());
        if (city.getId() == id){

            System.out.println(city);
            break;
        }try {
            if (!integerArrayList.contains(id)){
                throw new IndexOutOfBoundsException("There is no any city with this id");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }

}
}
