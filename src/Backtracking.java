import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Marcio on 29/09/2015.
 */
public class Backtracking {
    public static void main(String args[]){
        System.out.print("Digite o nome do arquivo de entrada:");
        //Le o nome de um arquivo de entrada
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        // Abre um arquivo pra leitura
        File file = new File(fileName);
        Scanner fileReader;
        try {
            fileReader = new Scanner(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir arquivo!");
            return;
        }

        // Leitura do numero de regiões do mapa e da heurística a ser utilizada
        int size = fileReader.nextInt();
        String heuristic = fileReader.next();

        String[] vertexes = new String[size];
        String[][] edges = new String[size][];

        // Leitura das entradas
        for (int i = 0; i < size; i++) {
            fileReader.useDelimiter(":");                                // Define ':' como delimitador
            vertexes[i] = fileReader.next();                             // Lê o nome da região do mapa
            if (i == 0 && vertexes[i].charAt(0) == '\n')
                vertexes[i] = vertexes[i].substring(1);             // Trata o caso do '\n' inicial
            edges[i] = fileReader.nextLine().substring(1).split(",");    // Lê o restante da linha e separa em strings

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
