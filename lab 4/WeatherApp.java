public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.displayForecast();
        weatherStation.checkTemperature();
    }
}