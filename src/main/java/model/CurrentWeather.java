package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
    private List<Weather> weather;
    private MainParametrs mainParametrs;
    private Wind wind;
    private Date time;
    private String city;

    public CurrentWeather(List<Weather> weather, MainParametrs mainParametrs, Wind wind, Date time, String city) {
        this.weather = weather;
        this.mainParametrs = mainParametrs;
        this.wind = wind;
        this.time = time;
        this.city = city;
    }

    public CurrentWeather() {
    }

    @JsonProperty("dt")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("main")
    public MainParametrs getMainParametrs() {
        return mainParametrs;
    }

    public void setMainParametrs(MainParametrs mainParametrs) {
        this.mainParametrs = mainParametrs;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("name")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "weather=" + weather +
                ", mainParametrs=" + mainParametrs +
                ", wind=" + wind +
                ", time='" + time + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
