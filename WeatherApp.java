public class WeatherApp {
    // Private data members
    private String city;
    private double temperature;
    private String condition;

    // Default constructor
    public WeatherApp() {
        this.city = "Unknown City";
        this.temperature = 0.0;
        this.condition = "Unknown Condition";
    }

    // Parameterized constructor with city and temperature
    public WeatherApp(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
        this.condition = "Unknown Condition";
    }

    // Parameterized constructor with all details
    public WeatherApp(String city, double temperature, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
    }

    // Setter method for updating weather condition
    public void setWeatherCondition(String condition) {
        this.condition = condition;
    }

    // Method overloading: Update temperature in Celsius
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // Method overloading: Update temperature in Fahrenheit
    public void setTemperature(double temperature, char scale) {
        if (scale == 'C') {
            this.temperature = temperature;
        } else if (scale == 'F') {
            this.temperature = (temperature - 32) * 5.0 / 9.0;
        }
    }

    // Display weather information
    public void displayWeather() {
        System.out.println("Weather in " + city + ": " + temperature + "°C, " + condition);
    }

    // Main method to demonstrate the WeatherApp class
    public static void main(String[] args) {
        WeatherApp weather1 = new WeatherApp();
        weather1.displayWeather();

        WeatherApp weather2 = new WeatherApp("New York", 25);
        weather2.displayWeather();

        WeatherApp weather3 = new WeatherApp("London", 77, "Sunny");
        weather3.displayWeather();

        // Updating temperature in Fahrenheit for weather3
        weather3.setTemperature(85, 'F');
        weather3.setWeatherCondition("Partly Cloudy");
        weather3.displayWeather();
    }
}
