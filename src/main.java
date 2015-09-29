import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Marcio on 29/09/2015.
 */
public class main {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        // Leitura do numero de regiões do mapa e da heurística a ser utilizada
        int size = input.nextInt();
        //System.out.println(size);
        String heuristic = input.next();
        //System.out.println(heuristic);

        String[] vertexes = new String[size];
        String[][] edges = new String[size][];

        //Inicialização do grafo
        for (int i = 0; i < size; i++) {
            // Leitura da entrada
            input.useDelimiter(":"); // Define ':' como delimitador
            vertexes[i] = input.next(); // Lê o nome da região do mapa
            if (i == 0 && vertexes[i].charAt(0) == '\n')
                vertexes[i] = vertexes[i].substring(1); // Trata o caso do '\n' inicial
            //System.out.print(regionName+" ");
            edges[i] = input.nextLine().substring(1).split(","); // Lê o restante da linha e separa em strings

            for (int j = 0; j < edges[i].length; j++) {
                // Formata os nomes
                edges[i][j] = edges[i][j].substring(1); // Remove o espaço do início da palavra
                if (j == edges[i].length-1) // Se é a ultima região
                    edges[i][j] = edges[i][j].substring(0, edges[i][j].length()-1); // Remove o ponto final
                //System.out.print(regionsName[j]+" ");

                //Region adjRegion = new Region(regionsName[j]);  // Cria região adjacente
                //map.addEdge(region, adjRegion); // Coloca a aresta no grafo
            }
            //System.out.print("\n");
        }

        // Criação e inicialização do grafo
        Graph map = new Graph(size);
        map.createGraph(vertexes, edges);

        System.out.print("AQUI!!\n");

        //map.paintMap(heuristic);
        //map.printMap();
        map.printGraph();
    }
}
