package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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

}
