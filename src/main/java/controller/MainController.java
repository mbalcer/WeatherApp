package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.CurrentWeather;
import weather.QueryCurrentWeather;

import java.io.IOException;
import java.util.Optional;

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

    private QueryCurrentWeather query;

    @FXML
    void changeCity() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("City name");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter the name of the city: ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            query.setLocation(result.get());
            downloadData();
        }
    }

    @FXML
    void closeApplication() {
        System.exit(0);
    }

    public void initialize() {
        query = new QueryCurrentWeather();
        downloadData();
    }

    private void downloadData() {
        ObjectMapper mapper = new ObjectMapper();
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
        String urlIcon = "/img/weather/"+currentWeather.getWeather().get(0).getIcon()+".png";
        imgWeather.setImage(new Image(urlIcon));
    }

}
