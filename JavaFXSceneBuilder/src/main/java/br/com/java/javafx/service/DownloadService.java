package br.com.java.javafx.service;

import br.com.java.javafx.task.DownloadTask;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Exemplo de uma classe para o uso de <i>Servico</i> no <b>JavaFX</b>.
 */
public class DownloadService extends Service<String> {

    @Override
    protected Task<String> createTask() {
        return new DownloadTask();
    }
}
