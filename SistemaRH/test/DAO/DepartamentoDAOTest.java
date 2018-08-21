/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Departamento;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class DepartamentoDAOTest {
    
    public DepartamentoDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento("Contabilidade");
        DepartamentoDAO dao = new DepartamentoDAO();
        dao.inserir(d);
    }

    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1, "Tecnologia da Informação");
        DepartamentoDAO dao = new DepartamentoDAO();
        dao.atualizar(d);
    }

    @Test
    @Ignore
    public void testDeletar() {
        Departamento d = new Departamento(2);
        DepartamentoDAO dao = new DepartamentoDAO();
        dao.deletar(d);
    }

    @Test
    @Ignore
    public void testListar() {
        DepartamentoDAO dao = new DepartamentoDAO();
        for (Departamento d: dao.listar()){
            System.out.println("Nome dpto: " + d.getNome() + " - " + d.getId());
        }
    }
    
}
