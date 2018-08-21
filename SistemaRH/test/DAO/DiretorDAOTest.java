/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Departamento;
import Models.Diretor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class DiretorDAOTest {
    
    public DiretorDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento(1);
        Departamento d2 = new Departamento(4);
        List<Departamento> departamentosGerenciados = new ArrayList();
        departamentosGerenciados.add(d);
        departamentosGerenciados.add(d2);
        
        Diretor dir = new Diretor(departamentosGerenciados, "minhasenha", 5000, 3, d, "JULIANA", "Junior", "159159159", "159159159", "3333-3333");
        DiretorDAO dao = new DiretorDAO();
        dao.inserir(dir);
    }
    
    @Test
    @Ignore
    public void testInserirDiretorDetartamento(){
        Departamento d = new Departamento(1);
        Departamento d2 = new Departamento(4);
        List<Departamento> departamentosGerenciados = new ArrayList();
        departamentosGerenciados.add(d);
        departamentosGerenciados.add(d2);
        Diretor dir = new Diretor(departamentosGerenciados, "minhasenha", 5000, 3, d, "Jhonny", "Junior", "159159159", "159159159", "3333-3333");
        DiretorDAO dao = new DiretorDAO();
        dao.inserirDiretorDepartamento(dir, 0);
    }
    
    @Test
    @Ignore
    public void testDeletar(){
        Diretor dir = new Diretor();
        dir.setCargoId(11);
        dir.setId(29);
        DiretorDAO dao = new DiretorDAO();
        dao.deletar(dir);
    }
    
    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1);
        Departamento d2 = new Departamento(1);
        Departamento d3 = new Departamento(1);
        Departamento d4 = new Departamento(4);
        List<Departamento> departamentosGerenciados = new ArrayList();
        departamentosGerenciados.add(d);
        departamentosGerenciados.add(d2);
        departamentosGerenciados.add(d3);
        departamentosGerenciados.add(d4);
        Diretor dir = new Diretor(departamentosGerenciados, "minhasenha", 9000, 3, 10, d, "JULIANA22", "Junior", "159159159", "159159159", "3333-3333");
        dir.setId(28);
        DiretorDAO dao = new DiretorDAO();
        dao.atualizar(dir);
    }
    
    @Test
    @Ignore
    public void listarDepartamentosDirigidos() {
        Diretor dir = new Diretor();
        dir.setCargoId(10);
        DiretorDAO dao = new DiretorDAO();
        for (Departamento d: dao.listarDepartamentosDirigidos(dir)){
            System.out.println("Nome: " + d.getNome() + ", ID: " + d.getId());
        }
    }
    
    @Test
    @Ignore
    public void listar() {
        DiretorDAO dao = new DiretorDAO();
        for (Diretor d: dao.listar()){
            System.out.println("Nome do diretor: " + d.getNome() + ", ID: " + d.getId());
            for (Departamento dep: d.getDepartamentosDirigidos()){
                System.out.println("-------------Departamento dirigido: " + dep.getNome() + ", ID do departamento: " + dep.getId());
            }
        }
    }

    
    
}
