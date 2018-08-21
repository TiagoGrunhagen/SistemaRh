package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost/sistemarh?useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco:" + e);
        }
        return null;
    }
    
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a Connection: " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar o Statement: " + ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar o ResultSet: " + ex);
            }
        }
        closeConnection(con, stmt);
    }

}
