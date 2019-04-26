package weather;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class QueryCurrentWeather {
    private final String API_KEY = "4b73e82c5827cb72b1fa6b02461cafd6";
    private String location;
    private String urlString;

    public QueryCurrentWeather() {
        this.location = "Warszawa";
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String makeQuery() {
        this.urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&APPID=" + API_KEY + "&units=metric";
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("There isn't such city");
            alert.showAndWait();
        }
        return result.toString();
    }
}
