package br.com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/aplicacao";
    private static final String user = "root";
    private static final String password = "root";
    
    private static Connection conn;
    
    public static Connection getConexao() throws SQLException {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
        } else {
                return conn;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
}
