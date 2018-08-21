/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class SistemaDAOTest {
    
    public SistemaDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Sistema s = new Sistema("Sistema de TI");
        SistemaDAO dao = new SistemaDAO();
        dao.inserir(s);
    }

    @Test
    @Ignore
    public void testAtualizar() {
        Sistema s = new Sistema(1, "Sistema Contábil Mega");
        SistemaDAO dao = new SistemaDAO();
        dao.atualizar(s);
    }

    @Test
    @Ignore
    public void testDeletar() {
        Sistema s = new Sistema(2);
        SistemaDAO dao = new SistemaDAO();
        dao.deletar(s);
    }

    @Test
    @Ignore
    public void testListar() {
        SistemaDAO dao = new SistemaDAO();
        for (Sistema s: dao.listar()){
            System.out.println("Nome do sistema e id: " + s.getNome() + " - " + s.getId());
        }
    }
    
}
