import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignInForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Sign In");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            System.out.println("Signed in: " + username);
        });

        VBox vbox = new VBox(10, usernameField, passwordField, loginButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign In Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
