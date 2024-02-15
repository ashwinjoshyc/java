package com.weather.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WeatherAppService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/weather";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "MySQL@password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to the database");

            createTable(connection); // Create the table if not exists

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("1. Add Weather Data");
                System.out.println("2. View Weather Data");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addWeatherData(connection);
                        break;
                    case 2:
                        viewWeatherData(connection);
                        break;
                    case 3:
                        System.out.println("Exiting the program");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS weather_data ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "city VARCHAR(255) NOT NULL,"
                + "temperature DOUBLE,"
                + "humidity DOUBLE,"
                + "observation_date DATE"
                + ")";

        try (PreparedStatement statement = connection.prepareStatement(createTableQuery)) {
            statement.execute();
        }
    }

    private static void addWeatherData(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter Temperature: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter Humidity: ");
        double humidity = scanner.nextDouble();
        System.out.print("Enter Observation Date (YYYY-MM-DD): ");
        String observationDate = scanner.next();

        String insertQuery = "INSERT INTO weather_data (city, temperature, humidity, observation_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, city);
            statement.setDouble(2, temperature);
            statement.setDouble(3, humidity);
            statement.setString(4, observationDate);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Weather data added successfully!");
            } else {
                System.out.println("Failed to add weather data.");
            }
        }
    }

    private static void viewWeatherData(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM weather_data";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Weather Data List:");
            System.out.println("ID\tCity\tTemperature\tHumidity\tObservation Date");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                double temperature = resultSet.getDouble("temperature");
                double humidity = resultSet.getDouble("humidity");
                String observationDate = resultSet.getString("observation_date");

                System.out.println(id + "\t" + city + "\t" + temperature + "\t" + humidity + "\t" + observationDate);
            }
        }
    }
}
