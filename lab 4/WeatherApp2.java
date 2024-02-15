import java.util.ArrayList;
import java.util.List;

// Generic class representing a WeatherReport
class WeatherReport<T> {
    private T weatherInfo;

    public WeatherReport(T weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public T getWeatherInfo() {
        return weatherInfo;
    }

    @Override
    public String toString() {
        return "WeatherReport{" +
                "weatherInfo=" + weatherInfo +
                '}';
    }
}

// Generic interface for WeatherStation management
interface WeatherStationManager<T> {
    void addWeatherReport(WeatherReport<T> weatherReport);

    List<WeatherReport<T>> getAllWeatherReports();
}

// WeatherStation class implementing WeatherStationManager interface for a specific type of weather information (e.g., String)
class WeatherStation<T> implements WeatherStationManager<T> {
    private List<WeatherReport<T>> weatherReports = new ArrayList<>();

    @Override
    public void addWeatherReport(WeatherReport<T> weatherReport) {
        weatherReports.add(weatherReport);
        System.out.println("Weather report added to the weather station: " + weatherReport);
    }

    @Override
    public List<WeatherReport<T>> getAllWeatherReports() {
        return weatherReports;
    }
}

public class WeatherApp2 {
    public static void main(String[] args) {
        // Create a weather station for String-based weather information
        WeatherStation<String> stringWeatherStation = new WeatherStation<>();

        // Add weather reports to the weather station
        stringWeatherStation.addWeatherReport(new WeatherReport<>("Sunny Day"));
        stringWeatherStation.addWeatherReport(new WeatherReport<>("Rainy Day"));

        // Get all weather reports in the weather station
        List<WeatherReport<String>> allWeatherReports = stringWeatherStation.getAllWeatherReports();
        System.out.println("All Weather Reports in the Weather Station: " + allWeatherReports);
    }
}
