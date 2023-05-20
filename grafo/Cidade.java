package grafo;

public class Cidade{
    private int codigo;
    private String nome;
    
    public Cidade(int cod, String nome){
        this.codigo = cod;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        
        return "codigo: " + codigo + "; nome: " + nome;
    }

   
}