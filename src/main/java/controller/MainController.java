package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.CurrentWeather;
import weather.QueryCurrentWeather;

import java.io.IOException;

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
        ObjectMapper mapper = new ObjectMapper();
        QueryCurrentWeather query = new QueryCurrentWeather();

        CurrentWeather currentWeather = null;
        try {
            currentWeather = mapper.readValue(query.makeQuery(), CurrentWeather.class);
        } catch (IOException e) {
            e.printStackTrace(); // todo exception handling
        }

        cityName.setText(currentWeather.getCity());
        temperature.setText(String.valueOf(currentWeather.getMainParametrs().getTemperature()) + " °C");
        pressure.setText("Pressure: " + String.valueOf(currentWeather.getMainParametrs().getPressure()) + " hPa");
        windSpeed.setText("Speed: " + currentWeather.getWind().getSpeed() + " m/s");
        windDirection.setText("Direction: " + currentWeather.getWind().getDeg() + "°");


    }

}
