/**
 * <ul>
 * <li>JSE - Java Standart Edition</li>
 * <li>JDK - Java Development Kit (Ferramentas para trabalhar com Java)</li>
 * <li>JRE - Java Runtime Environment (Ambiente de execução Java)</li>
 * <li>JEE - Java Enterprise Edition</li>
 * <li>JSF - Java Server Faces</li>
 * <li>JPA - Java Persistence API</li>
 * <li>EJB - Enterprise Java Beans</li>
 * <li>Java ME - Java Micro Edition</li>
 * <li>Servlets e JSP - Java Server Pages</li>
 * <li>Java Card, JavaFX e Java TV</li>
 * </ul>
 *
 * <p>
 * <b>JVM - Java Virtual Machine</b>
 * </p>
 *
 * O código fonte Java é compilado para um Bytecode Java. 
 * Esse bytecode é interpretado por cada JVM de cada sistema operacional.
 */
public class HelloWorld {
	
	/**
	 * <ul>
	 * <li>Para compilar a classe execute <i>javac</i> e o nome da classe <b>.java</b>.</li>
	 * <li>
	 * 		Para executar o bytecode gerado apos a compilacao execute o comando <i>java</i> 
	 * 		apenas com o nome da classe que sera executada.
	 * </li>
	 * </ul>
	 *
	 * @param args 
	 *			Argumentos passado via linha de comando
	 */
	public static void main(String[] args) {
		System.out.println("Oi Mundo!");		
	}
}