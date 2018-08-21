package DAO;

import JDBC.ConnectionFactory;
import Models.Acesso;
import Models.Funcionario;
import Models.Sistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcessoDAO {
    
    private Connection con = null;

    public AcessoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean autorizar(Funcionario funcionario, Sistema sistema){
        String sql = "INSERT INTO sistemafuncionario (funcionarioId, sistemaId) VALUES (?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.setInt(2, sistema.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção de autorização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean desautorizar(Acesso acesso){
        String sql = "DELETE FROM sistemafuncionario WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, acesso.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de inserção de autorização:" + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Acesso> listar(){
        String sql = "SELECT f.nome AS nomeFuncionario, s.nome AS nomeSistema, sf.id  FROM funcionario AS f JOIN sistemafuncionario AS sf ON f.id = sf.funcionarioId JOIN sistema AS s ON s.id = sf.sistemaId";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Acesso> acessos = new ArrayList();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nomeFuncionario"));
                Sistema sistema = new Sistema();
                sistema.setNome(rs.getString("nomeSistema"));
                Acesso acesso = new Acesso(rs.getInt("id"), funcionario, sistema);
                acessos.add(acesso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar a Query de busca:" + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return acessos;
    }
}
