package br.com.java.javafx.task;

import javafx.concurrent.Task;

/**
 * Exemplo de uma classe para o uso de <i>Tasks</i> no <b>JavaFX</b>.
 */
public class DownloadTask extends Task<String> {

    @Override
    protected String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            updateProgress(i + 1, 10);
            System.out.println("call(): " + i);

            if (isCancelled()) {
                break;
            }
        }

        return "OK";
    }

    @Override
    protected void running() {
        updateMessage("Download iniciado!");
    }

    @Override
    protected void succeeded() {
        updateMessage("Download encerrado!");
    }

    @Override
    protected void failed() {
        updateMessage("Download falhou!");
    }

    @Override
    protected void cancelled() {
        updateMessage("Download cancelado!");
    }

}
