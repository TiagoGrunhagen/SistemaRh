/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Departamento;
import Models.Gerente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class GerenteDAOTest {
    
    public GerenteDAOTest() {
    }

    @Test
    @Ignore
    public void testInserirCargo() {
        Departamento d = new Departamento(1);
        GerenteDAO dao = new GerenteDAO();
        dao.inserirCargo(d);
    }
    
    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento(1);
        Departamento d2 = new Departamento(4);
        Gerente g = new Gerente(d2, "minhasenha", 5000, 3, d, "Juvisval", "Junior", "159159159", "159159159", "3333-3333");
        GerenteDAO dao = new GerenteDAO();
        dao.inserir(g);
    }
    
    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1);
        Departamento d2 = new Departamento(4);
        Gerente g = new Gerente(d, "finazfinaz", 5000, 3, 5, d, "Juvisval", "Junior", "159159159", "159159159", "3333-3333");
        g.setId(11);
        GerenteDAO dao = new GerenteDAO();
        dao.atualizar(g);
    }
    
    @Test
    @Ignore
    public void testListar() {
        GerenteDAO dao = new GerenteDAO();
        for (Gerente g: dao.listar()){
            System.out.println("Cargo: " + g.getCargo() + ", Nome: " + g.getNome() + ", Departamento: " + g.getDepartamento().getNome() + ", ID: " + g.getId());
            System.out.println("Departamento gerenciado: " + g.getDepartamentoGerenciado().getNome() + ", ID da tabela gerente: " + g.getCargoId());
        }
    }
    
    @Test
    @Ignore
    public void testDeletar() {
        Gerente g = new Gerente();
        g.setId(18);
        g.setCargoId(12);
        GerenteDAO dao = new GerenteDAO();
        dao.deletar(g);
    }
    
}
