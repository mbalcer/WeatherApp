package utility;

import controller.MainController;
import javafx.application.Platform;

import java.util.TimerTask;

public class DataUpdate extends TimerTask {

    private MainController mainController;

    public DataUpdate(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void run() {
        Platform.runLater(() -> mainController.downloadData());
    }
}
