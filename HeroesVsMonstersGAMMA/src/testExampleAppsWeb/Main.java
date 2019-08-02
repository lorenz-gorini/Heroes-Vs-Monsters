package testExampleAppsWeb;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new BorderPane();
        Ship ship = new Ship();

        Scene scene = new Scene(root, 300, 275);
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.SPACE) {
                ship.fireRocket();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}