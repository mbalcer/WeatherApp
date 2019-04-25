import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;

    private void draggableWindow(AnchorPane anchorPane, final Stage stage) {
        anchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });

        anchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/mainView.fxml"));
        AnchorPane anchorPane = loader.load();
        draggableWindow(anchorPane, primaryStage);
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setOpacity(0.8);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
