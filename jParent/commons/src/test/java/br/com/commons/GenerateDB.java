package br.com.commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenerateDB {
	
	public static void main(String[] args) {

		System.out.println("Starting...");

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/applicationContext.xml");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) context).close();

		System.out.println("Executed successfully.");

	}

}
