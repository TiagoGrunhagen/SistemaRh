package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    private Connection con = null;

    public DepartamentoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Departamento departamento){
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, departamento.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean atualizar(Departamento departamento){
        String sql = "UPDATE departamento SET nome = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, departamento.getNome());
            stmt.setInt(2, departamento.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(Departamento departamento){
        String sql = "DELETE FROM departamento WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, departamento.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de exclusão:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Departamento> listar(){
        String sql = "SELECT * FROM departamento";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Departamento> departamentos = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("id"), rs.getString("nome"));
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return departamentos;
    }

    public int pessoasInseridas(Departamento departamento) {
        String sql = "SELECT * FROM funcionario WHERE departamentoId = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pessoas = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, departamento.getId());
            rs = stmt.executeQuery();
            while (rs.next()){
                pessoas++;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pessoas;
    }
    
    
    
}
