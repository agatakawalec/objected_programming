package sample;

import People.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

public class Main extends Application {
    Person first= new Person("John Smith", "0000000000", "8999");
    public static ObservableList names =
            FXCollections.observableArrayList();

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Add new Person");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        Label peselLabel = new Label("Pesel: ");
        gridPane.add(peselLabel, 0, 2);

        TextField peselField = new TextField();
        peselField.setPrefHeight(40);
        gridPane.add(peselField, 1, 2);

        Label phoneLabel = new Label("Phone: ");
        gridPane.add(phoneLabel, 0, 3);

        TextField phoneField = new TextField();
        phoneField.setPrefHeight(40);
        gridPane.add(phoneField, 1, 3);

        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter your name");
                    return;
                }
                if(peselField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter your email id");
                    return;
                }
                if(phoneField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter a password");
                    return;
                }

                Person nowy=new Person(nameField.getText(),peselField.getText(),phoneField.getText());
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
                        "Successfully added!", "Welcome " + nameField.getText());
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        final ListView listView = new ListView(names);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        names.addAll(first);

        listView.setItems(names);

        listView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>(){

            @Override
            public ListCell<Person> call(ListView<Person> p) {
                ListCell<Person> cell = new ListCell<Person>(){
                    @Override
                    protected void updateItem(Person t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getName() + "  " + t.getPesel());
                        }
                    }

                };

                return cell;
            }
        });

        Button show = new Button();
        show.setText("Show all");
        show.setLayoutX(100);
        show.setLayoutY(200);
        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button switchy=new Button("Home");
                switchy.setLayoutY(300);
                switchy.setLayoutX(300);
                Pane root2 = new Pane();
                root2.getChildren().add(listView);
                root2.getChildren().add(switchy);
                stage.setScene(new Scene(root2, 400, 400));

            }
        });

        Button add=new Button("Add new Person");
        add.setLayoutX(100);
        add.setLayoutY(250);
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createRegistrationFormPane();
                GridPane gridPane = createRegistrationFormPane();
                addUIControls(gridPane);
                Scene scene = new Scene(gridPane, 400,400);
                stage.setScene(scene);
                stage.show();
            }
        });

        Text hello=new Text("Welcome to People Program!");
        hello.setFont(new Font(20));
        hello.setWrappingWidth(200);
        hello.setTextAlignment(TextAlignment.JUSTIFY);
        hello.setX(70);
        hello.setY(40);

        Text menu=new Text("What do you want to do?");
        menu.setX(70);
        menu.setY(150);

        stage.setTitle("Handling people");
        Pane root = new Pane();
        root.getChildren().add(show);
        root.getChildren().add(hello);
        root.getChildren().add(menu);
        root.getChildren().add(add);
        Scene scene=new Scene(root, 400, 400);
        stage.setScene(scene);
        scene.getStylesheets().addAll(this.getClass().getResource("astyle.css").toExternalForm());
        stage.show();
    }

        public static void main (String[]args){
            launch(args);
        }
    }
