package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import Models.Programador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramadorDAO {
    
    private Connection con = null;

    public ProgramadorDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Programador programador){
        String sql = "INSERT INTO funcionario (nome, sobrenome, rg, cpf, telefone, senha, salario, nivel, cargo, departamentoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Programador', ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, programador.getNome());
            stmt.setString(2, programador.getSobrenome());
            stmt.setString(3, programador.getRg());
            stmt.setString(4, programador.getCpf());
            stmt.setString(5, programador.getTelefone());
            stmt.setString(6, programador.getSenha());
            stmt.setDouble(7, programador.getSalario());
            stmt.setInt(8, programador.getNivel());
            stmt.setInt(9, programador.getDepartamento().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean atualizar(Programador programador){
        String sql = "UPDATE funcionario  SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, senha = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, programador.getNome());
            stmt.setString(2, programador.getSobrenome());
            stmt.setString(3, programador.getRg());
            stmt.setString(4, programador.getCpf());
            stmt.setString(5, programador.getTelefone());
            stmt.setString(6, programador.getSenha());
            stmt.setDouble(7, programador.getSalario());
            stmt.setInt(8, programador.getNivel());
            stmt.setInt(9, programador.getDepartamento().getId());
            stmt.setInt(10, programador.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(Programador programador){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, programador.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Programador> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE cargo = 'Programador'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Programador> programadores = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                Programador programador = new Programador(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                programador.setId(rs.getInt("id"));
                programador.setCargo(rs.getString("cargo"));
                programadores.add(programador);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return programadores;
    }
    
    

}
