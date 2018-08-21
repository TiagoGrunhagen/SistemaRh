package Models;

import DAO.DepartamentoDAO;

public class Gerente extends Funcionario{
    
    Departamento departamentoGerenciado;

    //Sem cargo ID (para criar)
    public Gerente(Departamento departamentoGerenciado, String senha, double salario, int nivel, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(senha, salario, nivel, departamento, nome, sobrenome, rg, cpf, telefone);
        this.departamentoGerenciado = departamentoGerenciado;
    }
    
    //Com cargo ID (para editar)

    public Gerente(Departamento departamentoGerenciado, String senha, double salario, int nivel, int cargoId, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(senha, salario, nivel, cargoId, departamento, nome, sobrenome, rg, cpf, telefone);
        this.departamentoGerenciado = departamentoGerenciado;
    }
    

    public Gerente() {
    }

    public Departamento getDepartamentoGerenciado() {
        return departamentoGerenciado;
    }

    public void setDepartamentoGerenciado(Departamento departamentoGerenciado) {
        this.departamentoGerenciado = departamentoGerenciado;
    }

    
    @Override
    public String getRelatorio(){
        return "\n\n--------------- FUNCIONARIO ------------------\n" +
                "NOME COMPLETO: " + this.getNome() + " " + this.getSobrenome() + "\n" +
                "RG: " + this.getRg() + "\n" +
                "CPF: " + this.getCpf() + "\n" +
                "TELEFONE: " + this.getTelefone() + "\n" +
                "DEPARTAMENTO: " + this.getDepartamento().getNome() + "\n" +
                "CARGO: " + this.getCargo() + "\n" +
                "NIVEL: " + this.getNivel() + "\n" +
                "DEPARTAMENTO GERENCIADO: " + this.getDepartamentoGerenciado().getNome() + "\n" +
                "SALARIO " + this.getSalario() + ":\n" +
                "BONUS ANUAL: " + this.getBonus() + "";
    }
    
    @Override
    public double getBonus(){
        DepartamentoDAO dao = new DepartamentoDAO();
        int pessoas = dao.pessoasInseridas(this.departamentoGerenciado);
        return ((2 * this.salario) + (100 * pessoas));
    }
    
}
