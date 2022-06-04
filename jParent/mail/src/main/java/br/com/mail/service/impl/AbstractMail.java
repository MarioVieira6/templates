package br.com.mail.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Some information about the default email.
 */
public abstract class AbstractMail {
	
	/**
	 * Log4j.
	 *
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Project email. 
	 */
	protected static final String EMAIL_FROM = "jparent@project.com";
	
	/**
	 * Class to prepare sending email.
	 */
	protected JavaMailSender mailSender;

	/**
	 * Class to initialize template of the email.
	 */
	protected VelocityEngine velocityEngine;

	/**
	 * @param mailSender
	 *            mailSender.
	 */
	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * @param velocityEngine
	 *            velocityEngine.
	 */
	@Autowired
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
