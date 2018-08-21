/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Departamento;
import Models.Limpeza;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class LimpezaDAOTest {
    
    public LimpezaDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento(1);
        Limpeza l = new Limpeza(1200.00, 3, d, "Joana", "Dark", "124480213", "10655675965", "41991791053");
        LimpezaDAO dao = new LimpezaDAO();
        dao.inserir(l);
    }
    
    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1);
        Limpeza l = new Limpeza(1200.00, 3, d, "Jhonny", "Ronefon", "124480213", "10655675965", "41991791053");
        l.setId(3);
        LimpezaDAO dao = new LimpezaDAO();
        dao.atualizar(l);
    }
    
    @Test
    @Ignore
    public void testDeletar() {
        Limpeza l = new Limpeza();
        l.setId(5);
        LimpezaDAO dao = new LimpezaDAO();
        dao.deletar(l);
    }
    
    @Test
    @Ignore
    public void testListar() {
        LimpezaDAO dao = new LimpezaDAO();
        for (Limpeza l: dao.listar()){
            System.out.println(l.getCargo() + l.getNome() + l.getDepartamento().getNome() + l.getId());
        }
    }
    
}
