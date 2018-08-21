package DAO;

import JDBC.ConnectionFactory;
import Models.Analista;
import Models.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalistaDAO {
    
    private Connection con = null;

    public AnalistaDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Analista analista){
        String sql = "INSERT INTO funcionario (nome, sobrenome, rg, cpf, telefone, senha, salario, nivel, cargo, departamentoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Analista', ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, analista.getNome());
            stmt.setString(2, analista.getSobrenome());
            stmt.setString(3, analista.getRg());
            stmt.setString(4, analista.getCpf());
            stmt.setString(5, analista.getTelefone());
            stmt.setString(6, analista.getSenha());
            stmt.setDouble(7, analista.getSalario());
            stmt.setInt(8, analista.getNivel());
            stmt.setInt(9, analista.getDepartamento().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean atualizar(Analista analista){
        String sql = "UPDATE funcionario  SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, senha = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, analista.getNome());
            stmt.setString(2, analista.getSobrenome());
            stmt.setString(3, analista.getRg());
            stmt.setString(4, analista.getCpf());
            stmt.setString(5, analista.getTelefone());
            stmt.setString(6, analista.getSenha());
            stmt.setDouble(7, analista.getSalario());
            stmt.setInt(8, analista.getNivel());
            stmt.setInt(9, analista.getDepartamento().getId());
            stmt.setInt(10, analista.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(Analista analista){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, analista.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Analista> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE cargo = 'Analista'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Analista> analistas = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                Analista analista = new Analista(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                analista.setId(rs.getInt("id"));
                analista.setCargo(rs.getString("cargo"));
                analistas.add(analista);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return analistas;
    }

}
