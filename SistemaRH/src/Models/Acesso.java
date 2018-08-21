package Models;

import Models.Funcionario;
import Models.Sistema;

public class Acesso {
    
    private int id;
    private Funcionario funcionario;
    private Sistema sistema;

    public Acesso(Funcionario funcionario, Sistema sistema) {
        this.funcionario = funcionario;
        this.sistema = sistema;
    }

    public Acesso(int id, Funcionario funcionario, Sistema sistema) {
        this.id = id;
        this.funcionario = funcionario;
        this.sistema = sistema;
    }
    
    

    public Acesso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    
    
    
}
