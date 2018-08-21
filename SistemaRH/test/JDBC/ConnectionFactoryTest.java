/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhonny
 */
public class ConnectionFactoryTest {
    
    private Connection con = null;
    
    public ConnectionFactoryTest() {
    }

    @Test
    public void testSomeMethod() {
        con = ConnectionFactory.getConnection();
        if (con != null){
            System.out.println("Conexão feita com sucesso!");
        } else {
            System.err.println("Erro ao conectar!");
        }
    }
    
}
