import java.util.Scanner;

/**
 * Created by Marcio on 29/09/2015.
 */
public class main {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        // Leitura do numero de regi�es do mapa e da heur�stica a ser utilizada
        int size = input.nextInt();
        String heuristic = input.next();

        String[] vertexes = new String[size];
        String[][] edges = new String[size][];

        // Leitura das entradas
        for (int i = 0; i < size; i++) {
            input.useDelimiter(":");                                // Define ':' como delimitador
            vertexes[i] = input.next();                             // L� o nome da regi�o do mapa
            if (i == 0 && vertexes[i].charAt(0) == '\n')
                vertexes[i] = vertexes[i].substring(1);             // Trata o caso do '\n' inicial
            edges[i] = input.nextLine().substring(1).split(",");    // L� o restante da linha e separa em strings

            // Formata os nomes
            for (int j = 0; j < edges[i].length; j++) {
                edges[i][j] = edges[i][j].substring(1);             // Remove o espa�o do in�cio da palavra
                if (j == edges[i].length-1)                         // Se � a ultima regi�o
                    edges[i][j] = edges[i][j].substring(0, edges[i][j].length()-1); // Remove o ponto final
            }
        }

        // Cria��o e inicializa��o do grafo
        Graph map = new Graph(size);
        map.createGraph(vertexes, edges);

        // Execu��o da busca backtracking
        map.paintMap(heuristic);
        // Exibe a sa�da formatada
        map.printMap();
    }
}
