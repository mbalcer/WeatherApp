package utility;

import java.io.*;

public class WriteData {
    private final String FILE_PATH = "C:\\Users\\Mateusz\\.WeatherApp\\location.txt";

    public void writeLocation(String location) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(FILE_PATH);
            writer.write(location);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}
