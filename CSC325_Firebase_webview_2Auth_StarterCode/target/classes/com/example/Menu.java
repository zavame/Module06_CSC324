import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> Platform.exit());
        fileMenu.getItems().add(exitItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        Label mainLabel = new Label("Welcome");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(menuBar);
        mainLayout.setCenter(mainLabel);

        Scene mainScene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Main Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
