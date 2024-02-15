// Base class
class Weather {
    protected String location;
    protected double temperature;
    protected String conditions;

    // Constructor
    public Weather(String location, double temperature, String conditions) {
        this.location = location;
        this.temperature = temperature;
        this.conditions = conditions;
    }

    // Method to display weather information
    public void displayWeather() {
        System.out.println("Location: " + location);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Conditions: " + conditions);
    }
}

// Derived class
class WeatherForecast extends Weather {
    private int daysAhead;

    // Constructor
    public WeatherForecast(String location, double temperature, String conditions, int daysAhead) {
        super(location, temperature, conditions);
        this.daysAhead = daysAhead;
    }

    // Method to display weather forecast information
    public void displayWeatherForecast() {
        displayWeather(); // Call the base class method to display current weather
        System.out.println("Days Ahead: " + daysAhead + " days");
    }
}

// Main class
public class WeatherApp {
    public static void main(String[] args) {
        // Create an instance of the Weather class
        Weather currentWeather = new Weather("CityA", 25.5, "Sunny");

        // Display current weather
        System.out.println("Current Weather:");
        currentWeather.displayWeather();
        System.out.println();

        // Create an instance of the WeatherForecast class
        WeatherForecast forecast = new WeatherForecast("CityB", 22.0, "Partly Cloudy", 3);

        // Display weather forecast
        System.out.println("Weather Forecast:");
        forecast.displayWeatherForecast();
    }
}
