import java.util.*;

class Weather {
    private String city;
    private String condition;

    public Weather(String city, String condition) {
        this.city = city;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Weather in " + city + ": " + condition;
    }
}

class WeatherAppService {
    private List<Weather> weatherList;
    private Set<String> cities;
    private Map<String, Integer> temperatureMap;
    private Queue<Weather> forecastQueue;

    public WeatherAppService() {
        this.weatherList = new ArrayList<>();
        this.cities = new HashSet<>();
        this.temperatureMap = new HashMap<>();
        this.forecastQueue = new LinkedList<>();
    }

    public void addWeather(Weather weather) {
        weatherList.add(weather);
    }

    public void addCity(String city) {
        cities.add(city);
    }

    public void setTemperature(String city, int temperature) {
        temperatureMap.put(city, temperature);
    }

    public void addForecast(Weather weather) {
        forecastQueue.offer(weather);
    }

    public Weather cancelForecast() {
        return forecastQueue.poll();
    }

    public void displayWeather() {
        System.out.println("Weather Information:");
        for (Weather weather : weatherList) {
            System.out.println(weather);
        }
    }

    public void displayCities() {
        System.out.println("Cities: " + cities);
    }

    public void displayTemperatures() {
        System.out.println("Temperatures:");
        for (Map.Entry<String, Integer> entry : temperatureMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "°C");
        }
    }

    public void displayForecastQueue() {
        System.out.println("Forecast Queue:");
        for (Weather weather : forecastQueue) {
            System.out.println(weather);
        }
    }
}

public class WeatherApp {
    public static void main(String[] args) {
        WeatherAppService weatherAppService = new WeatherAppService();

        weatherAppService.addWeather(new Weather("New York", "Cloudy"));
        weatherAppService.addWeather(new Weather("Los Angeles", "Sunny"));
        weatherAppService.addWeather(new Weather("London", "Rainy"));

        weatherAppService.addCity("New York");
        weatherAppService.addCity("Los Angeles");
        weatherAppService.addCity("London");

        weatherAppService.setTemperature("New York", 20);
        weatherAppService.setTemperature("Los Angeles", 30);
        weatherAppService.setTemperature("London", 15);

        weatherAppService.addForecast(new Weather("New York", "Rainy"));
        weatherAppService.addForecast(new Weather("Los Angeles", "Partly Cloudy"));
        weatherAppService.addForecast(new Weather("London", "Clear Sky"));

        weatherAppService.displayWeather();
        weatherAppService.displayCities();
        weatherAppService.displayTemperatures();
        weatherAppService.displayForecastQueue();

        Weather cancelledForecast = weatherAppService.cancelForecast();
        System.out.println("Cancelled Forecast: " + cancelledForecast);
    }
}





