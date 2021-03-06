package Models;

public class Limpeza extends Funcionario{

    public Limpeza(double salario, int nivel, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(salario, nivel, departamento, nome, sobrenome, rg, cpf, telefone);
    }

    
   
    public Limpeza() {
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
                "SALARIO " + this.getSalario() + ":\n" +
                "BONUS ANUAL: " + this.getBonus() + "";
    }
    
    @Override
    public double getBonus(){
        return this.salario*0.5;
    }
   
    
    
}
