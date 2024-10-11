import com.example.csc325_firebase_webview_auth.model.Person;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private TableView<Person> tableView = new TableView<>();
    private int personIdCounter = 1;

    @Override
    public void start(Stage primaryStage) {
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> Platform.exit());
        fileMenu.getItems().add(exitItem);

        Menu userMenu = new Menu("User");
        MenuItem registerItem = new MenuItem("Register");
        userMenu.getItems().addAll(registerItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, userMenu);

        setupTableView();

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        TextField departmentField = new TextField();
        departmentField.setPromptText("Department");

        TextField majorField = new TextField();
        majorField.setPromptText("Major");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String department = departmentField.getText();
            String major = majorField.getText();
            String email = emailField.getText();

            if (!firstName.isEmpty() && !lastName.isEmpty() && !department.isEmpty() && !major.isEmpty() && !email.isEmpty()) {
                Person newPerson = new Person(personIdCounter++, firstName, lastName, department, major, email);
                personList.add(newPerson);
                clearFields(firstNameField, lastNameField, departmentField, majorField, emailField);
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> clearFields(firstNameField, lastNameField, departmentField, majorField, emailField));

        VBox formLayout = new VBox(10, firstNameField, lastNameField, departmentField, majorField, emailField, addButton, clearButton);
        formLayout.setStyle("-fx-background-color: #32CD32; -fx-padding: 10px;");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(menuBar);
        mainLayout.setLeft(formLayout);
        mainLayout.setCenter(tableView);

        Scene mainScene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("FSC CSC325 - Full Stack Project");
        primaryStage.show();
    }

    private void setupTableView() {
        TableColumn<Person, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Person, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Person, String> majorColumn = new TableColumn<>("Major");
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        TableColumn<Person, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, departmentColumn, majorColumn, emailColumn);
        tableView.setItems(personList);
    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
