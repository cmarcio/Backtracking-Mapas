import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Marcio on 29/09/2015.
 */
public class main {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        // Leitura do numero de regi�es do mapa e da heur�stica a ser utilizada
        int size = input.nextInt();
        //System.out.println(size);
        String heuristic = input.next();
        //System.out.println(heuristic);

        String[] vertexes = new String[size];
        String[][] edges = new String[size][];

        //Inicializa��o do grafo
        for (int i = 0; i < size; i++) {
            // Leitura da entrada
            input.useDelimiter(":"); // Define ':' como delimitador
            vertexes[i] = input.next(); // L� o nome da regi�o do mapa
            if (i == 0 && vertexes[i].charAt(0) == '\n')
                vertexes[i] = vertexes[i].substring(1); // Trata o caso do '\n' inicial
            //System.out.print(regionName+" ");
            edges[i] = input.nextLine().substring(1).split(","); // L� o restante da linha e separa em strings

            for (int j = 0; j < edges[i].length; j++) {
                // Formata os nomes
                edges[i][j] = edges[i][j].substring(1); // Remove o espa�o do in�cio da palavra
                if (j == edges[i].length-1) // Se � a ultima regi�o
                    edges[i][j] = edges[i][j].substring(0, edges[i][j].length()-1); // Remove o ponto final
                //System.out.print(regionsName[j]+" ");

                //Region adjRegion = new Region(regionsName[j]);  // Cria regi�o adjacente
                //map.addEdge(region, adjRegion); // Coloca a aresta no grafo
            }
            //System.out.print("\n");
        }

        // Cria��o e inicializa��o do grafo
        Graph map = new Graph(size);
        map.createGraph(vertexes, edges);

        System.out.print("AQUI!!\n");

        //map.paintMap(heuristic);
        //map.printMap();
        map.printGraph();
    }
}
