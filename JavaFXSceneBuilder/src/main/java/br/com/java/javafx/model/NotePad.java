package br.com.java.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Objeto que representa os campos da tela para uso de
 * <code>bindbidirectional</code>.
 */
public class NotePad {

    private StringProperty text = new SimpleStringProperty();
    private StringProperty textArea = new SimpleStringProperty();

    /**
     * @return the text
     */
    public final String getText() {
        return text.get();
    }

    /**
     * @param paramText
     *            the text to set
     */
    public final void setText(String paramText) {
        text.set(paramText);
    }

    /**
     * @return the textArea
     */
    public final String getTextArea() {
        return textArea.get();
    }

    /**
     * @param paramTextArea
     *            the textArea to set
     */
    public final void setTextArea(String paramTextArea) {
        textArea.set(paramTextArea);
    }

    /**
     * @return <i>property</i> do atributo <b>text</b>
     */
    public StringProperty textProperty() {
        return text;
    }

    /**
     * @return <i>property</i> do atributo <b>textArea</b>
     */
    public StringProperty textAreaProperty() {
        return textArea;
    }

    /**
     * Limpa valores das <i>properties</i>.
     */
    public void clear() {
        text.set("");
        textArea.set("");
    }

    @Override
    public String toString() {
        return String.format("Text: %s\nTextArea: %s", getText(), getTextArea());
    }
}
