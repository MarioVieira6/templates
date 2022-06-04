package br.com.mail.parameters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity with all attributes to send an email.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Parameters {

	/**
	 * Params.
	 */
	protected String appName;
	protected String pathTemplate;
	protected String subject;
	protected String emailTo;
	protected String emailCc;
	protected String emailBcc;
	protected String emailFrom;
	protected String message;

	/**
	 * Construtor
	 */
	public Parameters() {
		this.appName = "";
	}
}
