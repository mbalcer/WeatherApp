package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Weather;
import weather.QueryCurrentWeather;

import java.util.Map;

public class MainController {

    @FXML
    private Label cityName;

    @FXML
    private ImageView imgWeather;

    @FXML
    private Label temperature;

    @FXML
    private ImageView imgWind;

    @FXML
    private Label windSpeed;

    @FXML
    private Label windDirection;

    @FXML
    private Label pressure;

    @FXML
    private ImageView imgPressure;

    @FXML
    private JFXButton btnChange;

    @FXML
    private JFXButton btnClose;

    @FXML
    void changeCity() {

    }

    @FXML
    void closeApplication() {
        System.exit(0);
    }

    public void initialize() {
        downloadData();
    }

    private void downloadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        QueryCurrentWeather query = new QueryCurrentWeather();
        Map<String, Object> all =  query.jsonToMap(query.makeQuery());
        try {
            Map<String, Object> main = query.jsonToMap(objectMapper.writeValueAsString(all.get("main")));
            temperature.setText(String.valueOf(main.get("temp")) + " °C");
            pressure.setText("Pressure: " + String.valueOf(main.get("pressure")));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            Map<String, Object> wind = query.jsonToMap(objectMapper.writeValueAsString(all.get("wind")));
            windSpeed.setText("Speed: " + String.valueOf(wind.get("speed")));
            windDirection.setText("Direction: " + String.valueOf(wind.get("deg")));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        cityName.setText(query.getLocation());


    }

}
