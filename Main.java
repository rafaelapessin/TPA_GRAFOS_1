import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import grafo.Cidade;
import grafo.Grafo;
import grafo.Vertice;
import util.Leitor;

public class Main {
    static Grafo<Cidade> grafo = new Grafo<Cidade>();
    public static void main(String[] args) throws IOException{        
        try {
            lerGrafo("entrada_test.txt", grafo);
            
            int selection, codCidade;
            
            
            do {
                printMenu();
                selection = getSelection();
                switch (selection) {
                    // 1 - Obter cidades vizinhas
                    // o usuário deve informar o código de uma cidade e o programa deve exibir:
                    // - os códigos e nomes de todas as cidades vizinhas da cidade informada (vértices adjacentes) 
                    // - a distância da cidade escolhida para cada uma das vizinhas
                    case 1:
                        System.out.println("Informe o código da cidade: ");
                        codCidade = Leitor.getLeitor().nextInt();               // retorna o código da cidade que o usuário informou
                        grafo.obterCidadesVizinhas(new Cidade(codCidade, ""));
                        break;
                    // 2 - Obter todos os caminhos a partir de uma cidade
                    // o usuário deve informar o código de uma cidade e o programa deve exibir:
                    // - todas as cidades (código e nome) às quais é possível chegar saindo da cidade dada (seria um caminhamento em largura no grafo usando a cidade dada como vértice de origem do caminhamento)
                    case 2:
                        System.out.println("Informe o código da cidade: ");
                        codCidade = Leitor.getLeitor().nextInt();               // retorna o código da cidade que o usuário informou
                        grafo.obterCaminhos(new Cidade(codCidade, ""));
                        break;
                    case 3:
                        //METODO SAIR
                        break;
                    default:
                        break;
                }
            } while(selection != 3);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
        }
    }


    // MENU DE OPÇÕES
    private static void printMenu(){
        System.out.println("=================MENU=================");
        System.out.println("1 - Obter cidades vizinhas");
        System.out.println("2 - Obter todos os caminhos a partir de uma cidade");
        System.out.println("3 - Sair");
        System.out.println("======================================");
    } 
    
    private static int getSelection(){
        System.out.println("Escolha uma opcao: ");
        return Leitor.getLeitor().nextInt();
    }

    public static void lerGrafo(String path, Grafo<Cidade> grafo) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
	
		int qtdCidades = Integer.parseInt(buffRead.readLine());

		for(int i = 0; i < qtdCidades; i++){
			linha = buffRead.readLine();
            String[] line = linha.split(";");

			int cod = Integer.parseInt(line[0]);
            String cidade = line[1];
            Vertice<Cidade> vertice = new Vertice<Cidade>(new Cidade(cod,cidade));
			grafo.adicionarVertice(vertice);
		}

		for(int i = 1; i < qtdCidades + 1; i++){
            linha = buffRead.readLine();
			if(linha != null){
                String[] line = linha.split(";");

                for(int k = 0; k < qtdCidades; k++){
                    float peso = Float.parseFloat((line[k]).replaceAll(",", "."));

                    if(peso != 0){
                        Cidade origem = new Cidade(i,"");
                        Cidade destino = new Cidade((k+1),"");
                        grafo.adicionarAresta(peso, origem, destino);
                    }
                }
            }
		}
		buffRead.close();
	}
}
