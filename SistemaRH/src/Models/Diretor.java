package Models;

import java.util.List;

public class Diretor extends Funcionario{
    
    List<Departamento> departamentosDirigidos;

    //Sem cargoId (Para criar)

    public Diretor(List<Departamento> departamentosDirigidos, String senha, double salario, int nivel, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(senha, salario, nivel, departamento, nome, sobrenome, rg, cpf, telefone);
        this.departamentosDirigidos = departamentosDirigidos;
    }
    
    
    //Com cargo ID (para editar)
    public Diretor(List<Departamento> departamentosDirigidos, String senha, double salario, int nivel, int cargoId, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(senha, salario, nivel, cargoId, departamento, nome, sobrenome, rg, cpf, telefone);
        this.departamentosDirigidos = departamentosDirigidos;
    }

    //Sem list de departamento para facilitar na hora da pesquisa
    public Diretor(String senha, double salario, int nivel, int cargoId, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(senha, salario, nivel, cargoId, departamento, nome, sobrenome, rg, cpf, telefone);
    }

    public Diretor() {
    }

    public List<Departamento> getDepartamentosDirigidos() {
        return departamentosDirigidos;
    }

    public void setDepartamentosDirigidos(List<Departamento> departamentosDirigidos) {
        this.departamentosDirigidos = departamentosDirigidos;
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
                "DEPARTAMENTS DIRIGIDOS: " + this.getDepartamentosDirigidos().size() + "\n" +
                "SALARIO " + this.getSalario() + ":\n" +
                "BONUS ANUAL: " + this.getBonus() + "";
    }
    
    @Override
    public double getBonus(){
        return ((4 * this.salario) + (3000 * this.departamentosDirigidos.size()));
    }
   

}
