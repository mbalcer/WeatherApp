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

    public String readLocation() {
        BufferedReader reader = null;
        String location = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            location = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return location;
    }
}
