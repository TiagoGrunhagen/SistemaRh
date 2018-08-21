/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Funcionario;
import Models.Sistema;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class AcessoDAOTest {
    
    public AcessoDAOTest() {
    }

    @Test
    @Ignore
    public void testAutorizar() {
        Funcionario func = new Funcionario();
        func.setId(3);
        Sistema sis = new Sistema();
        sis.setId(1);
        AcessoDAO dao = new AcessoDAO();
        dao.autorizar(func, sis);
    }

    /*@Test
    @Ignore
    public void testDeletar() {
        Funcionario func = new Funcionario();
        func.setId(3);
        Sistema sis = new Sistema();
        sis.setId(1);
        AcessoDAO dao = new AcessoDAO();
        dao.desautorizar(func, sis);
    }

    @Test
    public void testListar() {
        AcessoDAO dao = new AcessoDAO();
        for (List<String> s: dao.listar()){
            for (String s2: s){
                System.out.printf(s2+" ");
            }
            System.out.println("\n");
        }
    }*/
    
}
