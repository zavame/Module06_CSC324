import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label splashLabel = new Label("CSC325");
        splashLabel.setStyle("-fx-font-size: 48px; -fx-text-fill: white;");

        StackPane root = new StackPane();
        root.getChildren().add(splashLabel);
        root.setStyle("-fx-background-color: purple;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Splash Screen");
        primaryStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> {
            new RegistrationForm().start(primaryStage);
        });
        delay.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
