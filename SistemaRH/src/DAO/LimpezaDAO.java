package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import Models.Limpeza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LimpezaDAO {
    
    private Connection con = null;

    public LimpezaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Limpeza limpeza){
        String sql = "INSERT INTO funcionario (nome, sobrenome, rg, cpf, telefone, salario, nivel, cargo, departamentoId) VALUES (?, ?, ?, ?, ?, ?, ?, 'Limpeza', ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, limpeza.getNome());
            stmt.setString(2, limpeza.getSobrenome());
            stmt.setString(3, limpeza.getRg());
            stmt.setString(4, limpeza.getCpf());
            stmt.setString(5, limpeza.getTelefone());
            stmt.setDouble(6, limpeza.getSalario());
            stmt.setInt(7, limpeza.getNivel());
            stmt.setInt(8, limpeza.getDepartamento().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean atualizar(Limpeza limpeza){
        String sql = "UPDATE funcionario SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, limpeza.getNome());
            stmt.setString(2, limpeza.getSobrenome());
            stmt.setString(3, limpeza.getRg());
            stmt.setString(4, limpeza.getCpf());
            stmt.setString(5, limpeza.getTelefone());
            stmt.setDouble(6, limpeza.getSalario());
            stmt.setInt(7, limpeza.getNivel());
            stmt.setInt(8, limpeza.getDepartamento().getId());
            stmt.setInt(9, limpeza.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(Limpeza limpeza){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, limpeza.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Limpeza> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE cargo = 'Limpeza'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Limpeza> limpezas = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                Limpeza limpeza = new Limpeza(rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                limpeza.setId(rs.getInt("id"));
                limpeza.setCargo(rs.getString("cargo"));
                limpezas.add(limpeza);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return limpezas;
    }
}
