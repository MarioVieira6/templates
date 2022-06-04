package br.com.mail.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import br.com.mail.parameters.Parameters;
import br.com.mail.service.Email;

/**
 * Implement email service.
 */
@SuppressWarnings("deprecation")
@Service("email")
public class EmailImpl extends AbstractMail implements Email {

	@Override
	public void send(Parameters ep) {

		logger.info("Enviar email");

		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				@SuppressWarnings({ "unchecked", "rawtypes" })
				public void prepare(MimeMessage mimeMessage) throws Exception {

					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

					message.setFrom(ep.getEmailFrom());
					InternetAddress[] a = InternetAddress.parse(ep.getEmailTo());
					message.setTo(a);
					message.setCc(ep.getEmailCc());
					message.setBcc(ep.getEmailBcc());
					message.setSubject(ep.getSubject());

					Map model = new HashMap();
					model.put("ep", ep);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "notificacao.html",
							model);

					message.setText(text, true);
				}
			};
			this.mailSender.send(preparator);
		} catch (Exception e) {
			logger.debug("[Service]" + e);
		}
	}

}
