 
abstract class WeatherReport {
    private String location;
    private String date;
    private double temperature;

    // Constructor
    public WeatherReport(String location, String date, double temperature) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
    }

    // Abstract method to provide additional weather details
    public abstract String getWeatherDetails();

    // Getters and setters
    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }
}

// Concrete class representing a daily weather report
class DailyWeatherReport extends WeatherReport {
    private String weatherCondition;

    // Constructor
    public DailyWeatherReport(String location, String date, double temperature, String weatherCondition) {
        super(location, date, temperature);
        this.weatherCondition = weatherCondition;
    }

    // Implementing the abstract method to provide additional weather details
    @Override
    public String getWeatherDetails() {
        // Additional details for daily weather report
        return "Weather Condition: " + weatherCondition;
    }
}

// Concrete class representing an extended weather forecast
final class ExtendedWeatherForecast extends WeatherReport {
    private int daysAhead;

    // Constructor
    public ExtendedWeatherForecast(String location, String date, double temperature, int daysAhead) {
        super(location, date, temperature);
        this.daysAhead = daysAhead;
    }

    // Implementing the abstract method to provide additional weather details
    @Override
    public String getWeatherDetails() {
        // Additional details for extended weather forecast
        return "Days Ahead: " + daysAhead + " days";
    }

    // Getter for days ahead
    public int getDaysAhead() {
        return daysAhead;
    }
}

// Example of using the WeatherApp
public class WeatherApp2 {
    public static void main(String[] args) {
        // Creating a daily weather report
        DailyWeatherReport dailyReport = new DailyWeatherReport("City Center", "2023-11-22", 25.0, "Sunny");
        System.out.println("Daily Weather Report for " + dailyReport.getLocation() + " - Temperature: " + dailyReport.getTemperature() + "°C - " + dailyReport.getWeatherDetails());

        // Creating an extended weather forecast
        ExtendedWeatherForecast extendedForecast = new ExtendedWeatherForecast("Suburb Area", "2023-11-22", 22.5, 5);
        System.out.println("Extended Weather Forecast for " + extendedForecast.getLocation() + " - Temperature: " + extendedForecast.getTemperature() + "°C - " + extendedForecast.getWeatherDetails());
    }
}