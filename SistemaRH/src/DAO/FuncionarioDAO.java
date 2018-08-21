package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import Models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private Connection con = null;

    public FuncionarioDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public List<Funcionario> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                Funcionario funcionario = new Funcionario(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        }
        return funcionarios;
    }
    
    public List<Funcionario> listarFiltrado(String campo, String filtro){
        String sql = "";
        switch (campo){
            case "Nome":
                sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE f.nome LIKE ?";
                break;
            case "Sobrenome":
                sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE f.sobrenome LIKE ?";
                break;
            case "RG":
                sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE f.rg LIKE ?";
                break;
            case "CPF":
                sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE f.cpf LIKE ?";
                break;
            case "Cargo":
                sql = "SELECT f.*, d.nome AS nomeDepartamento, d.id AS idDepartamento FROM funcionario AS f JOIN departamento AS d ON d.id = f.departamentoId WHERE f.cargo LIKE ?";
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, filtro);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                Funcionario funcionario = new Funcionario(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }
    
    public Funcionario buscaFuncionario(int id){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento FROM funcionario AS f JOIN departamento AS d ON f.departamentoId = d.id WHERE f.id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("departamentoId"), rs.getString("nomeDepartamento"));
                Funcionario funcionario = new Funcionario(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo(rs.getString("cargo"));
                return funcionario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public boolean atualizar(Funcionario funcionario){
        String sql = "UPDATE funcionario  SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, senha = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setString(3, funcionario.getRg());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getSenha());
            stmt.setDouble(7, funcionario.getSalario());
            stmt.setInt(8, funcionario.getNivel());
            stmt.setInt(9, funcionario.getDepartamento().getId());
            stmt.setInt(10, funcionario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de atualização:" + e);
            return false;
        }
    }
    
    public List<Funcionario> listarCpf(String nome){
        String sql = "SELECT * FROM funcionario WHERE cpf LIKE ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }
    
    public Funcionario buscaFuncionario(String cpf){
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento();
                Funcionario funcionario = new Funcionario(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setCargo(rs.getString("cargo"));
                return funcionario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        }
        return null;
    }

    public boolean temAcesso(Funcionario func, String sistema) {
        String sql = "SELECT sf.*, s.nome AS nomeSistema FROM sistemafuncionario AS sf JOIN sistema AS s ON s.id = sf.sistemaId";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                if (rs.getString("nomeSistema").equals(sistema)){
                    if (rs.getInt("funcionarioId") == func.getId()){
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return false;
    }
    
    

}
