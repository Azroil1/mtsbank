package ru.mtsbank.hw.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.modelsanimalsdatabase.Creature;
import ru.mtsbank.hw.modelsanimalsdatabase.Habitat;
import ru.mtsbank.hw.modelsanimalsdatabase.Provider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalsDataBaseJDBC {
    @Value("${data-connection.url}")
    private String URL;

    @Value("${data-connection.name}")
    private String name;

    @Value("${data-connection.password}")
    private String password;

    public AnimalsDataBaseJDBC() {

    }

    public List<Creature> getListCreature(){
        List<Creature> creatureList = new ArrayList<>();
            try (Connection con = DriverManager.getConnection(URL, name, password)){
                PreparedStatement statement = con.prepareStatement("SELECT * FROM animals.creature");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    creatureList.add(new Creature(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getInt(3), resultSet.getShort("age"), resultSet.getDate("birth_date").toLocalDate()));
                }
            } catch (SQLException e) {
                System.out.println("SQL problem in query");
                e.printStackTrace();
            }
        return creatureList;
    }

    public List<Habitat> getListHabitat(){
        List<Habitat> habitatList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, name, password)){
            PreparedStatement statement = con.prepareStatement("SELECT * FROM animals.habitat");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                habitatList.add(new Habitat(resultSet.getString(2), resultSet.getLong(1)));
            }
        } catch (SQLException e) {
            System.out.println("SQL problem in query");
            e.printStackTrace();
        }
        return habitatList;
    }

    public List<Provider> getListProvider(){
        List<Provider> providerList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, name, password)){
            PreparedStatement statement = con.prepareStatement("SELECT * FROM animals.creature");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                providerList.add(new Provider(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println("SQL problem in query");
            e.printStackTrace();
        }
        return providerList;
    }

}
