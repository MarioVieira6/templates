/**
 *
 */
package br.com.java.javafx.controller;

import br.com.java.javafx.screen.IndexApp;
import br.com.java.javafx.screen.NotePadApp;
import br.com.java.javafx.service.DownloadService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <p>
 * O <b>IndexController</b> eh responsavel por manipular os <b>metodos</b> e
 * <b>propriedades</b> do arquivo <b>.fxml</b> referenciado.
 * </p>
 *
 * <p>
 * Para referenciar o arquivo <b>.fxml</b> com o <b>IndexController</b> criado
 * basta usar o atributo <code>fx:controller="[caminho do seu controller]"
 * no componente <i>pai</i> do seu <b>layout</b>:</code>
 *
 * <pre>
 *      fx:controller="br.com.java.javafx.controller.IndexController"
 * </pre>
 * </p>
 *
 * <p>
 * Atraves do atributo <code>onAction</code> presente em um componente do
 * arquivo <b>.fxml</b> eh possivel fazer a referencia do nome da acao com o
 * metodo criado no <b>IndexController</b>.
 * </p>
 *
 * <p>
 * Com a anotacao <code>@FXML</code> eh possivel conectar a acao ou o componente
 * do arquivo <b>.fxml</b> com a acao ou <i>bind</i> do <b>IndexController</b>.
 * </p>
 *
 * <p>
 * Para entender melhor esses conceitos, compare o exemplo <b>Layout.fxml</b>
 * com este <b>IndexController</b>.
 * </p>
 */
public class IndexController {

    @FXML
    private ProgressBar progress;

    @FXML
    private Label lblPercent;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Text txtStatusBar;

    private DownloadService service;

    /**
     * Metodo que inicializa o <b>IndexController</b>. Todos os controles de
     * <i>binds</i> e <i>listener</i> sao manipulados neste metodo em tempo de
     * execucao.
     */
    public void initialize() {
        service = new DownloadService();

        // Fazendo bind com servico
        progress.progressProperty().bind(service.progressProperty());
        txtStatusBar.textProperty().bind(service.messageProperty());

        service.progressProperty().addListener((event, oldValue, newValue) -> {
            Double progress = (Double) newValue;

            if (progress < 0) {
                lblPercent.setText(null);
            } else {
                lblPercent.setText(String.format("%.0f%%", progress * 100));
            }

            if (progress == 1) {
                try {
                    IndexApp.close();
                    new NotePadApp().start(new Stage());
                } catch (Exception e) {
                    System.out.println("Erro ao fechar tela!");
                }
            }
        });

        btnCancelar.disableProperty().bind(service.runningProperty().not());
        btnIniciar.disableProperty().bind(service.runningProperty());
    }

    /**
     * Iniciar execucao do servico.
     */
    @FXML
    public void start() {
        service.restart();
    }

    /**
     * Cancelar execucao do servico.
     */
    @FXML
    public void cancel() {
        service.cancel();
    }
}
