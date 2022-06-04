package br.com.mail;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Configuration test about email project.
 */
public abstract class EmailTest {
	
	protected ApplicationContext context = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath*:/**/applicationContext-mail.xml");
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		((ClassPathXmlApplicationContext) context).close();
	}

}
