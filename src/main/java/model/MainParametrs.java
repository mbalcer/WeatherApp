package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainParametrs {
    private Double temperature;
    private Integer pressure;

    public MainParametrs(Double temperature, Integer pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public MainParametrs() {
    }

    @JsonProperty("temp")
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "MainParametrs{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                '}';
    }
}
