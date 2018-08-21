/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Departamento;
import Models.Programador;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jhonny
 */
public class ProgramadorDAOTest {
    
    public ProgramadorDAOTest() {
    }

    @Test
    @Ignore
    public void testInserir() {
        Departamento d = new Departamento(1);
        Programador p = new Programador("minhasenha", 1200.00, 3, d, "Jhonnyzes", "Dark", "124480213", "10655675965", "41991791053");
        ProgramadorDAO dao = new ProgramadorDAO();
        dao.inserir(p);
    }

    @Test
    @Ignore
    public void testAtualizar() {
        Departamento d = new Departamento(1);
        Programador p = new Programador("novasenha", 1200.00, 3, d, "Jhonnyzes", "Dark", "124480213", "10655675965", "41991791053");
        p.setId(6);
        ProgramadorDAO dao = new ProgramadorDAO();
        dao.atualizar(p);
    }

    @Test
    @Ignore
    public void testDeletar() {
        Programador p = new Programador();
        p.setId(6);
        ProgramadorDAO dao = new ProgramadorDAO();
        dao.deletar(p);
    }

    @Test
    @Ignore
    public void testListar() {
        ProgramadorDAO dao = new ProgramadorDAO();
        for (Programador p: dao.listar()){
            System.out.println(p.getCargo() + p.getNome() + p.getDepartamento().getNome() + p.getId());
        }
    }
    
}
