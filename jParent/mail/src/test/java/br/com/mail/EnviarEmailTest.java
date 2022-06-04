package br.com.mail;

import org.junit.Test;

import br.com.mail.parameters.Parameters;
import br.com.mail.service.Email;

/**
 * Send an email.
 */
public class EnviarEmailTest extends EmailTest {
	
	/**
	 * Spring
	 */
	private Email mail;

	
	/**
	 * jUnit.
	 */
	@Test
	public void eeTest(){
		mail = (Email) context.getBean("email");
		
		Parameters ep = new Parameters();
		
		ep.setEmailFrom("marioviera.mvj@gmail.com");
		ep.setEmailTo("marioviera.mvj@gmail.com");
		ep.setSubject("[jParent]-Email test");
		ep.setMessage("Test");
		
		mail.send(ep);
	}
}
