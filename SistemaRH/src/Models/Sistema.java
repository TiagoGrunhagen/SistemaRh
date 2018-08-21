package Models;

public class Sistema {
    private int id;
    private String nome;

    public Sistema(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Sistema(String nome) {
        this.nome = nome;
    }

    public Sistema(int id) {
        this.id = id;
    }

    public Sistema() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
