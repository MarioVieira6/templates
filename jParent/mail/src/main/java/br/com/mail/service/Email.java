package br.com.mail.service;

import br.com.mail.parameters.Parameters;

/**
 * Project only send emails.
 */
public interface Email {
	
	/**
	 * Send email.
	 */
	void send(Parameters ep);

}
