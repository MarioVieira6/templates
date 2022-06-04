package br.com.commons.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;

/**
 * 
 */
public class LogPeriod {
	
	/**
	 * Params.
	 */
	private Log logger;
	private long startTime;
	private long endTime;
	private String description;
	private SimpleDateFormat sdf;
	
	/**
	 * Construtor
	 */
	public LogPeriod(Log logger) {
		this.logger = logger;
		this.sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
	}
	
	/**
	 * @param timeMillis
	 * @return
	 */
	@SuppressWarnings("unused")
	private String format(long timeMillis){
		return sdf.format(timeMillis);
	}
	
	/**
	 * @param description
	 */
	public void start(String description){
		this.startTime = System.currentTimeMillis();
		this.description = description;
		logger.info(this.description);
	}
	
	/**
	 * 
	 */
	public void end(){
		this.endTime = System.currentTimeMillis();
		logger.info(this.description + " - Total: " + (endTime - startTime) / 1000d + "ms");
	}

}
