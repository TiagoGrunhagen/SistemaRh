/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Analista;
import Models.Departamento;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class AnalistaDAOTest {
    
    public AnalistaDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento(1);
        Analista a = new Analista("minhasenha", 1200.00, 3, d, "Jhonnyzes", "Dark", "124480213", "10655675965", "41991791053");
        AnalistaDAO dao = new AnalistaDAO();
        dao.inserir(a);
    }

    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1);
        Analista a = new Analista("minhasenha", 3000.00, 3, d, "Jhonnyzes", "Dark", "124480213", "10655675965", "41991791053");
        a.setId(9);
        AnalistaDAO dao = new AnalistaDAO();
        dao.atualizar(a);
    }

    @Test
    @Ignore
    public void testDeletar() {
        Analista a = new Analista();
        a.setId(9);
        AnalistaDAO dao = new AnalistaDAO();
        dao.deletar(a);
    }

    @Test
    @Ignore
    public void testListar() {
        AnalistaDAO dao = new AnalistaDAO();
        for (Analista a: dao.listar()){
            System.out.println(a.getCargo() + a.getNome() + a.getDepartamento().getNome() + a.getId());
        }
    }
    
}
