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

    private final String URL = "jdbc:mysql://localhost:3306/AppRH";
    private final String USER = "root";
    private final String PASSWORD = "16934";

    private MySQLConnection() {}

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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver de MySQL", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD); // ← crea nueva conexión
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    
//    public static void main(String[] args) {
//        MySQLConnection connSingleton = MySQLConnection.getInstance();
//        try {
//            Connection conn = connSingleton.getConnection();
//            if (conn != null && !conn.isClosed()) {
//                System.out.println("¡Conexión a la base de datos establecida exitosamente!");
//                connSingleton.closeConnection(conn);
//            } else {
//                System.out.println("No se pudo establecer la conexión.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
//        }
//    }

}    

