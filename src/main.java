import java.util.Scanner;

/**
 * Created by Marcio on 29/09/2015.
 */
public class main {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        // Leitura do numero de regiões do mapa e da heurística a ser utilizada
        int size = input.nextInt();
        String heuristic = input.next();

        String[] vertexes = new String[size];
        String[][] edges = new String[size][];

        // Leitura das entradas
        for (int i = 0; i < size; i++) {
            input.useDelimiter(":");                                // Define ':' como delimitador
            vertexes[i] = input.next();                             // Lê o nome da região do mapa
            if (i == 0 && vertexes[i].charAt(0) == '\n')
                vertexes[i] = vertexes[i].substring(1);             // Trata o caso do '\n' inicial
            edges[i] = input.nextLine().substring(1).split(",");    // Lê o restante da linha e separa em strings

            // Formata os nomes
            for (int j = 0; j < edges[i].length; j++) {
                edges[i][j] = edges[i][j].substring(1);             // Remove o espaço do início da palavra
                if (j == edges[i].length-1)                         // Se é a ultima região
                    edges[i][j] = edges[i][j].substring(0, edges[i][j].length()-1); // Remove o ponto final
            }
        }

        // Criação e inicialização do grafo
        Graph map = new Graph(size);
        map.createGraph(vertexes, edges);

        // Execução da busca backtracking
        map.paintMap(heuristic);
        // Exibe a saída formatada
        map.printMap();
    }
}
