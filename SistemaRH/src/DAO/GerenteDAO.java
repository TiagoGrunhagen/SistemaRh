package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import Models.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO {
    
    private Connection con = null;

    public GerenteDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Gerente gerente){
        String sql = "INSERT INTO funcionario (nome, sobrenome, rg, cpf, telefone, senha, salario, nivel, cargo, departamentoId, cargoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Gerente', ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getSobrenome());
            stmt.setString(3, gerente.getRg());
            stmt.setString(4, gerente.getCpf());
            stmt.setString(5, gerente.getTelefone());
            stmt.setString(6, gerente.getSenha());
            stmt.setDouble(7, gerente.getSalario());
            stmt.setInt(8, gerente.getNivel());
            stmt.setInt(9, gerente.getDepartamento().getId());
            int cargoId = inserirCargo(gerente.getDepartamentoGerenciado());
            stmt.setInt(10, cargoId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /* Recebe como parâmetro o departamento que vai ser Gerenciado */
    public int inserirCargo(Departamento departamento){
        String sql = "INSERT INTO gerente (departamentoGerenciado) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, departamento.getId());
            stmt.executeUpdate();
            return getUltimoId();
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return 0;
        }
    }
    
    //Retorna o ID da instancia Gerente que acabou de ser inserida
    public int getUltimoId(){
        String sql = "SELECT MAX(id) AS ultimoId FROM gerente";
        PreparedStatement stmt = null;
        int ultimoId = 0;
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ultimoId = rs.getInt("ultimoId");
            }
            return ultimoId;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return 0;
        }
    }
    
    public boolean atualizar(Gerente gerente){
        String sql = "UPDATE funcionario  SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, senha = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getSobrenome());
            stmt.setString(3, gerente.getRg());
            stmt.setString(4, gerente.getCpf());
            stmt.setString(5, gerente.getTelefone());
            stmt.setString(6, gerente.getSenha());
            stmt.setDouble(7, gerente.getSalario());
            stmt.setInt(8, gerente.getNivel());
            stmt.setInt(9, gerente.getDepartamento().getId());
            stmt.setInt(10, gerente.getId());
            atualizarDepartamentoGerenciado(gerente);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void atualizarDepartamentoGerenciado(Gerente gerente){
        String sql = "UPDATE gerente SET departamentoGerenciado = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, gerente.getDepartamentoGerenciado().getId());
            stmt.setInt(2, gerente.getCargoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
        }
    }
    
    public boolean deletar(Gerente gerente){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, gerente.getId());
            stmt.executeUpdate();
            deletarGerente(gerente);
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void deletarGerente(Gerente gerente){
        String sql = "DELETE FROM gerente WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, gerente.getCargoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
        }
    }
    
    public List<Gerente> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento, d2.nome AS departamentoGerenciado, d2.id AS departamentoGerenciadoId FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId JOIN gerente AS g ON f.cargoId = g.id JOIN departamento AS d2 ON d2.id = g.DepartamentoGerenciado WHERE cargo = 'Gerente'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Gerente> gerentes = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamentoGerenciado = new Departamento(rs.getInt("departamentoGerenciadoId"), rs.getString("departamentoGerenciado"));
                Departamento departamento = new Departamento(rs.getInt("departamentoId"), rs.getString("nomeDepartamento"));
                Gerente gerente = new Gerente(departamentoGerenciado, rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), rs.getInt("cargoId"),departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                gerente.setId(rs.getInt("id"));
                gerente.setCargo(rs.getString("cargo"));
                gerentes.add(gerente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return gerentes;
    }

    public int getCargoId(Gerente gerente) {
        String sql = "SELECT cargoId FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        int cargoId = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, gerente.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                cargoId = rs.getInt("cargoId");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção:" + e);
        }
        return cargoId;
    }
    

}
