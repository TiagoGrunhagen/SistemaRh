package Interfaces;

import Models.Funcionario;
import Models.Sistema;


public interface Autenticavel {
    public boolean autentica(String senha, String usuario, String sistema);
}
