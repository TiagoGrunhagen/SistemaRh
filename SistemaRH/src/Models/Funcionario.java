package Models;

import DAO.FuncionarioDAO;
import Interfaces.Autenticavel;

public class Funcionario extends Pessoa implements Comparable, Autenticavel{
    int id;
    String senha;
    double salario;
    int nivel;
    String cargo;
    int cargoId;
    Departamento departamento;

    public Funcionario(String senha, double salario, int nivel, int cargoId, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(nome, sobrenome, rg, cpf, telefone);
        this.senha = senha;
        this.salario = salario;
        this.nivel = nivel;
        this.cargoId = cargoId;
        this.departamento = departamento;
    }

    //SEM CARGO ID
    public Funcionario(String senha, double salario, int nivel, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(nome, sobrenome, rg, cpf, telefone);
        this.senha = senha;
        this.salario = salario;
        this.nivel = nivel;
        this.departamento = departamento;
    }

    //SEM CARGO ID E SEM SENHA (LIMPEZA)
    public Funcionario(double salario, int nivel, Departamento departamento, String nome, String sobrenome, String rg, String cpf, String telefone) {
        super(nome, sobrenome, rg, cpf, telefone);
        this.salario = salario;
        this.nivel = nivel;
        this.departamento = departamento;
    }
    
    public String getRelatorio(){return null;}
    public double getBonus(){return 0;}
    
    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int compareTo(Object o) {
        Funcionario func = (Funcionario) o;
        if (this.getSalario() > func.getSalario()){
            return 1;
        } else if (this.getSalario() < func.getSalario()){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean autentica(String senha, String usuario, String sistema) {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario func = dao.buscaFuncionario(usuario);       
        if (func.getCargo().equals("Limpeza")){
            return false;
        }
        if (func.getSenha().equals(senha)){
            if (func.getCargo().equals("Diretor")){
                return true;
            } else if (dao.temAcesso(func, sistema)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
