package br.com.java.javafx.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Aplicacao de exemplo usando <i>Layouts</i> basicos.
 */
public class JavaFXApplication extends Application {

    /**
     * Metodo principal que executa a aplicacao <b>JavaFX</b>.
     *
     * @param args
     *            Argumentos via linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // firstExample(primaryStage);
        secondExample(primaryStage);
    }

    /**
     * <p>
     * Primeiro exemplo de aplicacao.
     * </p>
     *
     * <p>
     * Esta aplicacao eh um formulario simples de cadastro sem eventos, apenas
     * por amostragem.
     * </p>
     *
     * @param primaryStage
     *            Container que inicializa o tela com os componentes
     */
    @SuppressWarnings("unused")
    private final void firstExample(Stage primaryStage) {
        primaryStage.setTitle("Form");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(7.0));

        GridPane grid = new GridPane();
        grid.setHgap(5.0);
        grid.setVgap(7.0);

        grid.add(new Label("Name:"), 0, 0);
        TextField txtNome = new TextField();
        GridPane.setHgrow(txtNome, Priority.ALWAYS);
        grid.add(txtNome, 1, 0);

        grid.add(new Label("E-mail:"), 0, 1);
        TextField txtEmail = new TextField();
        GridPane.setHgrow(txtEmail, Priority.ALWAYS);
        grid.add(txtEmail, 1, 1);

        grid.add(new Label("Sex:"), 0, 2);
        RadioButton btnMasc = new RadioButton("Male");
        btnMasc.setSelected(true);
        RadioButton btnFem = new RadioButton("Female");

        ToggleGroup group = new ToggleGroup();
        btnMasc.setToggleGroup(group);
        btnFem.setToggleGroup(group);

        HBox radioBox = new HBox(5.0, btnMasc, btnFem);
        grid.add(radioBox, 1, 2);

        grid.add(new Label("State:"), 0, 3);
        ChoiceBox<String> chcEstados = new ChoiceBox<String>();
        ObservableList<String> estados = FXCollections
                .observableArrayList("Paraná", "Săo Paulo", "Pernambuco", "Amazonas", "Mato Grosso do Sul");
        chcEstados.setItems(estados);
        chcEstados.getSelectionModel().select(0);
        grid.add(chcEstados, 1, 3);

        root.setCenter(grid);

        HBox buttonBar = new HBox(5.0);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);
        Button btnGravar = new Button("Save");
        Button btnCancelar = new Button("Cancel");
        buttonBar.getChildren().addAll(btnGravar, btnCancelar);

        root.setBottom(buttonBar);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * <p>
     * Segundo exemplo com um evento simples.
     * </p>
     *
     * <p>
     * Esta aplicacao eh bloco de notas com um evento de exemplo no botao
     * <b>Save</b>.
     * </p>
     *
     * @param primaryStage
     *            Container que inicializa o tela com os componentes
     */
    private final void secondExample(Stage primaryStage) {
        primaryStage.setTitle("Notepad");

        BorderPane root = new BorderPane();

        TextArea txtContent = new TextArea();
        txtContent.setFont(Font.font("Courier New", 14));
        root.setCenter(txtContent);

        Menu menuFile = new Menu("_File");
        MenuItem menuItemExit = new MenuItem("_Exit");
        menuFile.getItems().add(menuItemExit);
        MenuBar menuBar = new MenuBar(menuFile);
        root.setTop(menuBar);

        Button btnSave = new Button("Save");
        btnSave.setOnAction(event -> showDialog("It's just a simple example!"));

        Button btnCancel = new Button("Cancel");

        HBox buttonBox = new HBox(5.0, btnSave, btnCancel);
        buttonBox.setPadding(new Insets(7.0));
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Apresenta uma mensagem de alerta.
     *
     * @param msg
     *            Mensagem que sera exibida no <b>Dialog</b>
     */
    private void showDialog(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Message");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
