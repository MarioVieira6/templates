package br.com.java.javafx.controller;

import br.com.java.javafx.model.NotePad;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * <p>
 * O <b>NotePadController</b> eh responsavel por manipular os <b>metodos</b> e
 * <b>propriedades</b> do arquivo <b>.fxml</b> referenciado.
 * </p>
 *
 * <p>
 * Para referenciar o arquivo <b>.fxml</b> com o <b>NotePadController</b> criado basta
 * usar o atributo <code>fx:controller="[caminho do seu controller]"
 * no componente <i>pai</i> do seu <b>layout</b>:</code>
 *
 * <pre>
 *      fx:controller="br.com.java.javafx.controller.NotePadController"
 * </pre>
 * </p>
 *
 * <p>
 * Atraves do atributo <code>onAction</code> presente em um componente do
 * arquivo <b>.fxml</b> eh possivel fazer a referencia do nome da acao com o
 * metodo criado no <b>NotePadController</b>.
 * </p>
 *
 * <p>
 * Com a anotacao <code>@FXML</code> eh possivel conectar a acao ou o componente
 * do arquivo <b>.fxml</b> com a acao ou <i>bind</i> do <b>NotePadController</b>.
 * </p>
 *
 * <p>
 * Para entender melhor esses conceitos, compare o exemplo <b>Layout.fxml</b>
 * com este <b>NotePadController</b>.
 * </p>
 */
public class NotePadController {

    @FXML
    MenuItem menuItem;

    @FXML
    TextArea textArea;

    @FXML
    TextField text;

    @FXML
    Label label;

    @FXML
    Button button;

    private NotePad notePad;

    /**
     * Metodo que inicializa o <b>NotePadController</b>. Todos os controles de
     * <i>binds</i> e <i>listener</i> sao manipulados neste metodo em tempo de
     * execucao.
     */
    public <T> void initialize() {
        notePad = new NotePad();
        notePad.setTextArea("Inicializando TextArea");
        notePad.setText("Inicializando TextField!");

        // Exemplo de bind unidirecional
        // label.textProperty().bind(text.textProperty());

        // Exemplo de bind bidirecional
        // text.textProperty().bindBidirectional(textArea.textProperty());

        /*
         * Binds bidirecional com uso de um objeto
         */
        text.textProperty().bindBidirectional(notePad.textProperty());
        textArea.textProperty().bindBidirectional(notePad.textAreaProperty());

        // Exemplo de Listener
        textArea.textProperty().addListener((o, ov, nv) -> {
            int length = nv.length();

            if (length <= 50) {
                label.setText("TEXTO PEQUENO!");
            } else if (length > 50 && length <= 200) {
                label.setText("TEXTO MÉDIO!");
            } else {
                label.setText("TEXTO GRANDE!");
            }
        });

        button.disableProperty().bind(textArea.textProperty().isEmpty().or(text.textProperty().isEmpty()));
    }

    /**
     * <p>
     * Metodo que implementa a acao do botao <b>Gravar</b>.
     * </p>
     */
    @FXML
    public void save() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gravar!");
        alert.setHeaderText("Dados salvo com sucesso!");
        alert.setContentText(notePad.toString());
        alert.showAndWait();
    }

    /**
     * <p>
     * Metodo que implementa a acao do botao <b>Cancelar</b>.
     * </p>
     */
    @FXML
    public void cancel() {
        notePad.clear();
    }
}
