/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Quicknote;

import java.sql.Connection;
import util.ConnectionFactory;
import static util.ConnectionFactory.closeConnection;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        // iniciar uma conex�o com o banco de dados
        Connection connection = ConnectionFactory.getConnection();
        
        // encerrar a conex�o com o banco de dados
        closeConnection(connection);
    }
}