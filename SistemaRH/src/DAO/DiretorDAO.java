package DAO;

import JDBC.ConnectionFactory;
import Models.Departamento;
import Models.Diretor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiretorDAO {
    
    private Connection con = null;

    public DiretorDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserir(Diretor diretor){
        String sql = "INSERT INTO funcionario (nome, sobrenome, rg, cpf, telefone, senha, salario, nivel, cargo, departamentoId, cargoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Diretor', ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, diretor.getNome());
            stmt.setString(2, diretor.getSobrenome());
            stmt.setString(3, diretor.getRg());
            stmt.setString(4, diretor.getCpf());
            stmt.setString(5, diretor.getTelefone());
            stmt.setString(6, diretor.getSenha());
            stmt.setDouble(7, diretor.getSalario());
            stmt.setInt(8, diretor.getNivel());
            stmt.setInt(9, diretor.getDepartamento().getId());
            int cargoId = inserirCargo();
            stmt.setInt(10, cargoId);
            stmt.executeUpdate();
            inserirDiretorDepartamento(diretor, cargoId);
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção funcionário:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Cria instancia de diretor e retorna o ID inserido
    public int inserirCargo(){
        String sql = "INSERT INTO diretor VALUES ()";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return getUltimoId();
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção cargo:" + e);
            return 0;
        }
    }
    
    //Retorna o ID da instancia Gerente que acabou de ser inserida
    public int getUltimoId(){
        String sql = "SELECT MAX(id) AS ultimoId FROM diretor";
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
            System.err.println("Erro ao executar a Query consulta UltimoID:" + e);
            return 0;
        }
    }
    
    //Cria a relação entra diretor e departamentos gerenciados
    public void inserirDiretorDepartamento(Diretor diretor, int cargoId){
        for (Departamento d: diretor.getDepartamentosDirigidos()){
            String sql = "INSERT INTO diretordepartamento (diretorId, departamentoId) VALUES (?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, cargoId);
                stmt.setInt(2, d.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erro ao executar a Query de inserção diretordepartamento:" + e);
            }
        }
    }
    
    //Exclui o registro da tabela funcionario
    public boolean deletar(Diretor diretor){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diretor.getId());
            stmt.executeUpdate();
            deletarDiretor(diretor);
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de exclusão funcionário:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Exclui o registro da tabela diretor
    public boolean deletarDiretor(Diretor diretor){
        String sql = "DELETE FROM diretor WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diretor.getCargoId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de exclusão diretor:" + e);
            return false;
        }
    }
    
    public boolean atualizar(Diretor diretor){
        String sql = "UPDATE funcionario SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ?, senha = ?, salario = ?, nivel = ?, departamentoId = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, diretor.getNome());
            stmt.setString(2, diretor.getSobrenome());
            stmt.setString(3, diretor.getRg());
            stmt.setString(4, diretor.getCpf());
            stmt.setString(5, diretor.getTelefone());
            stmt.setString(6, diretor.getSenha());
            stmt.setDouble(7, diretor.getSalario());
            stmt.setInt(8, diretor.getNivel());
            stmt.setInt(9, diretor.getDepartamento().getId());
            stmt.setInt(10, diretor.getId());
            stmt.executeUpdate();
            excluirDepartamentosDirigidos(diretor);
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção funcionário:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean excluirDepartamentosDirigidos(Diretor diretor){
        String sql = "DELETE FROM diretordepartamento WHERE diretorId = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diretor.getCargoId());
            stmt.executeUpdate();
            inserirDiretorDepartamento(diretor, diretor.getCargoId());
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção funcionário:" + e);
            return false;
        }
    }

    public List<Diretor> listar(){
        String sql = "SELECT f.*, d.nome AS nomeDepartamento FROM funcionario AS f JOIN departamento AS d ON f.departamentoId = d.id WHERE cargo = 'Diretor'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Diretor> diretores = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("departamentoId"), rs.getString("nomeDepartamento"));
                Diretor diretor = new Diretor(rs.getString("senha"), rs.getDouble("salario"), rs.getInt("nivel"), rs.getInt("cargoId"), departamento, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"));
                diretor.setDepartamentosDirigidos(listarDepartamentosDirigidos(diretor));
                diretor.setId(rs.getInt("id"));
                diretor.setCargo(rs.getString("cargo"));
                diretores.add(diretor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return diretores;
    }
    
    public List<Departamento> listarDepartamentosDirigidos(Diretor diretor){
        String sql = "SELECT dd.*, dep.nome AS nomeDepartamento, dep.id as idDepartamento FROM diretordepartamento AS dd JOIN departamento AS dep ON dep.id = departamentoId WHERE diretorId = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Departamento> departamentos = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diretor.getCargoId());
            rs = stmt.executeQuery();
            while (rs.next()){
                Departamento departamento = new Departamento(rs.getInt("idDepartamento"), rs.getString("nomeDepartamento"));
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca de departamentos gerenciados:" + e);
        }
        return departamentos;
    }

    public int getCargoId(Diretor diretor) {
        String sql = "SELECT cargoId FROM funcionario WHERE id = ?";
        PreparedStatement stmt = null;
        int cargoId = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diretor.getId());
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
