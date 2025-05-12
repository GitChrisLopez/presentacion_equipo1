/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author paula
 */
public class MySQLConnection implements IConnection {

       private static MySQLConnection instance;
    private static Connection connection;
    
    // Datos de la base de datos
    private final String URL = "jdbc:mysql://localhost:3306/AppRH"; // Cambia el nombre de la base de datos
    private final String USER = "root";  // Usuario de la base de datos
    private final String PASSWORD = "Trufita.99";  // Contraseña de la base de datos

    // Constructor privado para evitar instanciación desde otras clases
    private MySQLConnection() {
    }

    // Método para obtener la instancia única de MySQLConnection (Patrón Singleton)
    public static MySQLConnection getInstance() {
        if (instance == null) {
            synchronized (MySQLConnection.class) {
                if (instance == null) {
                    instance = new MySQLConnection();
                }
            }
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Cargar el driver de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("No se pudo cargar el driver de MySQL", e);
            }
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
}
    
    public static void main(String[] args) {
        MySQLConnection connSingleton = MySQLConnection.getInstance();
        try {
            Connection conn = connSingleton.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("¡Conexión a la base de datos establecida exitosamente!");
                connSingleton.closeConnection(conn);
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

}    

