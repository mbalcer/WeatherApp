import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, Object> jsonToMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) {
        String API_KEY = "4b73e82c5827cb72b1fa6b02461cafd6";
        String LOCATION = "Bydgoszcz";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&APPID=" + API_KEY + "&units=metric";

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println(result);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> all = jsonToMap(result.toString());
            Map<String, Object> main = jsonToMap(objectMapper.writeValueAsString(all.get("main")));
            System.out.println("Temperature in Bydgoszcz: " + main.get("temp"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
