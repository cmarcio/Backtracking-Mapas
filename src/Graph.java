import java.util.ArrayList;

/**
 * Created by Marcio on 29/09/2015.
 */
public class Graph {
    int V;
    ArrayList<Vertex> vertexes;

    Graph(int V) {
        this.V = V;
        vertexes = new ArrayList<Vertex>(V);
    }

    public void addVertexes(String[] names){
        for (int i = 0; i < V; i++)
            vertexes.add(i, new Vertex(names[i], i));
    }

    public void addEdges(int index, String[] edgeNames){
        vertexes.get(index).addEdges(edgeNames.length, edgeNames);
    }

    public void createGraph(String[] vertexNames, String[][] edgeNames) {
        addVertexes(vertexNames);
        for(int i = 0; i < V; i++){
            addEdges(i, edgeNames[i]);
        }
    }

    public boolean paintMap(String heuristic) {
        return backtracking(heuristic);
    }

    // Exucuta o método de backtracking de acordo com a rotina escolhida
    public boolean backtracking(String heuristic) {
        switch (heuristic) {
            case "a":
                // Backtracking Simples
                simpleRecursiveBacktracking(vertexes);
                break;
            case "b":
                System.out.println("Backtracking com verificação adiante");
                break;
            case "c":
                System.out.println("Backtracking com verificação adiante e MVR");
                break;
            case "d":
                System.out.println("Backtracking com verificação adiante, MVR e grau");
                break;
        }
        return true;
    }

    public boolean simpleRecursiveBacktracking(ArrayList< Vertex> assignments) {
        if (assignments.stream().filter(s -> s.getColor() == 0).count() == 0) // Se a solução foi encontrada
            return true;

        Vertex var = assignments.stream().filter(s -> s.getColor() == 0).findFirst().get(); // Seleciona uma variável sem atribuição
        for (int color = 1; color < 5; color++) {   // Para cada elemento do domínio
            if (checkAssignment(var, color)){       // Verfica se é válido
                var.setColor(color);                // Atribui o valor à variável
                Boolean success = simpleRecursiveBacktracking(assignments); // Chama o método recursivamente
                if (success) return success;        // Se houve exito retorna true
                var.setColor(0);                    // Caso contrário, remove a atribuição
            }
        }
        return false; // Retorna false, pois n encontrou uma atribuição válida
    }

    // verifica se a atribuição de um vértice não é a mesma de um de seus adjacentes
    public boolean checkAssignment(Vertex vertex, int color) {
        for (int i = 0; i < vertex.getE(); i++) {                   // Para cada vertice adjacente
            String edgeName = vertex.getEdges().get(i).getName();   // Copia o nome do vértice destino
            if (vertexes.stream().filter(s->s.getName().compareTo(edgeName) == 0).filter(s->s.color == color).count() != 0)
                return false;               // Se existe um adjacente com a mesma atribuição, retorna false
        }
        return true;    // Caso contrário, retorna true
    }

    public void printGraph(){
        for (int i = 0; i < V; i++) {
            vertexes.get(i).printVertex();
            System.out.print("\n");
        }
    }

    // Imprime o mapa com seus respectivas cores
    public void printMap(){
        for(int i  = 0; i < V; i++){
            System.out.print(vertexes.get(i).getName()+": ");
            int color = vertexes.get(i).getColor();
            switch (color){
                case 1:
                    System.out.println("Azul.");
                    break;
                case 2:
                    System.out.println("Amarelo.");
                    break;
                case 3:
                    System.out.println("Verde.");
                    break;
                case 4:
                    System.out.println("Vermelho.");
                    break;
                case 0:
                    System.out.println("NO COLOR.");
                    break;
            }
        }
    }
}
