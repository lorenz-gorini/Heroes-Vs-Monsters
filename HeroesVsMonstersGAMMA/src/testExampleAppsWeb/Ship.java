package testExampleAppsWeb;

import heroes.components.Hero;
import heroes.components.Warrior;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Ship {

    private boolean readyToFireRocket = true;

    private static final double ROCKET_LAUNCHING_DELAY = 2d;

    public void fireRocket() {
        if(readyToFireRocket) {
            readyToFireRocket = false;
            System.out.println("Rocket is fired");

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(ROCKET_LAUNCHING_DELAY),
                e -> readyToFireRocket = true);
            Timeline reloadRockets = new Timeline(keyFrame);
            reloadRockets .play();
        }
    }
}
/* IN ANOTHER FILE MAIN:

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

*/