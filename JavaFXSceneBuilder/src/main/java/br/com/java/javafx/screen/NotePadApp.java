package br.com.java.javafx.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Aplicacao de exemplo usando <i>Layouts</i> no formato <b>FXML</b>.
 *
 */
public class NotePadApp extends Application {

    private static Stage stage;

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
        stage = primaryStage;

        Pane pane = FXMLLoader.load(getClass().getResource("/br/com/java/javafx/view/Layout.fxml"));

        Scene scene = new Scene(pane, 600, 800);
        scene.getStylesheets().add("styles.css");

        stage.setTitle("FXMLOrSceneBuilder");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Fecha a tela principal.
     */
    public static void close() {
        stage.close();
    }
}
