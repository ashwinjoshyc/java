public class WeatherStation implements Forecast, Weather {
    @Override
    public void displayForecast() {
        // Implementation to display weather forecast
        System.out.println("Weather forecast displayed");
    }

    @Override
    public void checkTemperature() {
        // Implementation to check the current temperature
        System.out.println("Temperature checked successfully");
    }
}