package br.com.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Trigger specific log with Spring AspectJ.
 */
@Aspect
public class AspectLog {
	
	/**
	 * Logs.
	 */
	public static Log logger = LogFactory.getLog(AspectLog.class);
	
	private LogPeriod period;
	private Boolean enabled;
	private final static String PROPERTIES_FILENAME = "commons.properties";
	private final static String ENABLED_PROPERTY = "aspect.log.enabled";

	/**
	 * Construtor
	 */
	public AspectLog() {
		readProperties();
	}

	/**
	 * Read properties
	 */
	private void readProperties() {
		Properties properties = new Properties();
		InputStream input = null;

		try {
			input = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
			properties.load(input);
			this.enabled = Boolean.valueOf(properties.getProperty(ENABLED_PROPERTY));
		} catch (Exception e) {
			logger.error("Erro ao ler a propriedade " + ENABLED_PROPERTY, e);
			this.enabled = Boolean.FALSE;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("Error: "+e);
				}
			}
		}
	}

	/**
	 * Under construction
	 */
	@Pointcut("within(br.com..*)")
	public void businessEntryPoint() {
	}

	/**
	 * @param joinPoint
	 */
	@Before("businessEntryPoint()")
	public void beforeBusinessEntryPoint(JoinPoint joinPoint) {
		this.period = new LogPeriod(logger);

		if (this.enabled) {
			Signature signature = joinPoint.getSignature();
			this.period.start(signature.getDeclaringTypeName() + "." + signature.getName());
		}
	}

	/**
	 * @param joinPoint
	 */
	@After("businessEntryPoint()")
	public void afterBusinessEntryPoint(JoinPoint joinPoint) {
		if (this.enabled)
			this.period.end();
	}

}
