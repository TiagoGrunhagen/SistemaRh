package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {
    public static void main (String[] args){
    
        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario();
        Funcionario f3 = new Funcionario();
        Funcionario f4 = new Funcionario();
        
        f1.setSalario(1000);
        f2.setSalario(2000);
        f3.setSalario(155);
        f4.setSalario(10);
        
        List<Funcionario> funcionarios = new ArrayList();
        
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);
        
        Collections.sort(funcionarios);
        
        for (Funcionario f: funcionarios){
            System.out.println("Salario: " + f.getSalario());
        }
        
        
        
        
        
        
        
        
        
        
    }
}
