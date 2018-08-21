package DAO;

import JDBC.ConnectionFactory;
import Models.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SistemaDAO {
    
    private Connection con = null;

    public SistemaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Sistema sistema){
        String sql = "INSERT INTO sistema (nome) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sistema.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean atualizar(Sistema sistema){
        String sql = "UPDATE sistema SET nome = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sistema.getNome());
            stmt.setInt(2, sistema.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(Sistema sistema){
        String sql = "DELETE FROM sistema WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sistema.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de exclusão:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Sistema> listar(){
        String sql = "SELECT * FROM sistema";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sistema> sistemas = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Sistema sistema = new Sistema(rs.getInt("id"), rs.getString("nome"));
                sistemas.add(sistema);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return sistemas;
    }
    
    public List<Sistema> listarFiltrado(String nome){
        String sql = "SELECT * FROM sistema WHERE nome LIKE ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sistema> sistemas = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()){
                Sistema sistema = new Sistema(rs.getInt("id"), rs.getString("nome"));
                sistemas.add(sistema);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return sistemas;
    }
    
    
}
