import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            System.out.println("Registered: " + username);
        });

        VBox vbox = new VBox(10, usernameField, passwordField, registerButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
