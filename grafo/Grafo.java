// RAFAELA AMORIM PESSIN
// TPA 2023/1
// GRAFOS - PARTE 1

package grafo;

import java.util.ArrayList;

// Um grafo é representado computacionalmente por uma lista de adjacências, que é uma lista de de vértices conectados por arestas
// Um grafo representa um conjunto de vértices (cidades) e um conjunto de arestas (caminhos) que conectam esses vértices
public class Grafo<T>{
    private ArrayList<Vertice<T>> vertices;

    public Grafo(){
        this.vertices =  new ArrayList<Vertice<T>>();
    }

    public void adicionarVertice(Vertice<T> vertice){
        this.vertices.add(vertice);
    }

    public Vertice<T> getVertice(T dado){
        if(dado == null) return null;
        for(Vertice<T> vert: this.vertices){
            // Verifica se o vertice atual contém o Objeto igual ao que está sendo procurado
            if(vert.getValor().equals(dado)){
                return vert;
            }
        }
        return null;
    }

    // Passa o vértice de origem e o vértice de destino e a distância entre os vértices para criar uma aresta/caminho entre cidades
    public void adicionarAresta(Float distancia, T vInicio, T vFim){
        Vertice<T> origem = this.getVertice(vInicio);
        Vertice<T> destino = this.getVertice(vFim);
        origem.adicionarDestino(new Aresta<T>(distancia, destino));
    }

    // Imprime todas as cidades vizinhas/adjacentes a uma cidade de origem
    public void obterCidadesVizinhas(T dado){        
        for(Vertice<T> vertice: vertices){
            // Verifica se o vertice atual contém a Cidade igual a que está sendo procurada
            if(vertice.getValor().equals(dado)){
                System.out.println("Cidade escolhida:" + vertice.getValor());
                // Imprime todas as cidades vizinhas
                for(Aresta<T> aresta: vertice.getDestinos()){
                    System.out.println(aresta);
                }
            }
        }
    }    

    // O método pega no grafo o vértice da cidade de origem
    // Em seguida faz um caminhamento no grafo para encontrar os caminhos a partir dele.
    public void obterCaminhos(T dado){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();

        Vertice<T> atual = getVertice(dado);
        fila.add(atual);
        //Pego o primeiro vértice como ponto de partida e coloco na fila
        //Poderia escolher qualquer outro...
        //Mas note que dependendo do grafo pode ser que você não caminhe por todos os vétices

        //Enquanto houver vertice na fila...
        while (fila.size()>0){
            //Pego o próximo da fila, marco como visitado e o imprimo
            atual = fila.get(0);
            fila.remove(0);
            marcados.add(atual);
            System.out.println(atual.getValor());
            //Depois pego a lista de adjacencia do nó e se o nó adjacente ainda
            //não tiver sido visitado, o coloco na fila
            
            ArrayList<Aresta<T>> destinos = atual.getDestinos();
            Vertice<T> proximo;

            for (int i=0; i<destinos.size();i++){
                proximo = destinos.get(i).getDestino();
                if(!marcados.contains(proximo) && !fila.contains(proximo)){
                    fila.add(proximo);
                }
            }
        }
    }
}