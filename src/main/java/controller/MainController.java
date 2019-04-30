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
import utility.DataUpdate;
import weather.QueryCurrentWeather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class MainController {

    @FXML
    private Label cityName;

    @FXML
    private Label weatherDescription;

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
    private Label humidity;

    @FXML
    private ImageView imgPressure;

    @FXML
    private JFXButton btnChange;

    @FXML
    private JFXButton btnClose;

    @FXML
    private Label updateDate;

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
        Timer timer = new Timer();
        timer.schedule(new DataUpdate(this), 0, 1000*60);
    }

    public void downloadData() {
        ObjectMapper mapper = new ObjectMapper();
        CurrentWeather currentWeather = null;
        try {
            currentWeather = mapper.readValue(query.makeQuery(), CurrentWeather.class);
            setFieldInView(currentWeather);
        } catch (IOException e) {
            System.out.println("Error during read");
        }
    }

    private void setFieldInView(CurrentWeather currentWeather) {
        cityName.setText(currentWeather.getCity());
        weatherDescription.setText(capitalize(currentWeather.getWeather().get(0).getDescription()));
        temperature.setText(currentWeather.getMainParametrs().getTemperature() + " °C");
        pressure.setText("Pressure: " + currentWeather.getMainParametrs().getPressure() + " hPa");
        humidity.setText("Humidity: " + currentWeather.getMainParametrs().getHumidity() + "%");
        updateDate.setText("Data on time: "+new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date(currentWeather.getTime().getTime()*1000)));
        if (currentWeather.getWind().getDeg() == null)
            windDirection.setText("");
        else {
            currentWeather.getWind().setDirection();
            windDirection.setText("Direction: " + currentWeather.getWind().getDirection());
        }
        if (currentWeather.getWind().getSpeed() == null)
            windSpeed.setText("Speed: 0 m/s");
        else
            windSpeed.setText("Speed: " + currentWeather.getWind().getSpeed() + " m/s");

        String urlIcon = "/img/weather/"+currentWeather.getWeather().get(0).getIcon()+".png";
        imgWeather.setImage(new Image(urlIcon));
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
