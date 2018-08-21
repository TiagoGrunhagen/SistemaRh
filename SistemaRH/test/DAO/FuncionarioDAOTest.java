/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhonny
 */
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }

    @Test
    public void testListar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        for (Funcionario f: dao.listar()){
            System.out.println("Cargo: " + f.getCargo() + ", Nome: " + f.getNome() + ", Departamento: " + f.getDepartamento().getNome() + ", ID: " + f.getId());
        }
    }
    
}
