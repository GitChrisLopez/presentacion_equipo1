/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BDconexion;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author paula
 */
public interface IConnection {
    
      Connection getConnection() throws SQLException;
      void closeConnection (Connection connection) throws SQLException; 
}
