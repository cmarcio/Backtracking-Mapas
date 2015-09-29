import sun.security.provider.certpath.AdjacencyList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Vector;

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

    public boolean backtracking(String heuristic) {
        switch (heuristic) {
            case "a":
                System.out.println("Backtracking Simples");
                //ArrayList<Region> assignments = new ArrayList<>(size);
                //for (int i = 0; i < size; i++)
                   // assignments.add(i, vertex.get(i));
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

        Vertex var = assignments.stream().filter(s -> s.getColor() == 0).findFirst().get();
        //System.out.println("["+var.getIndex()+"]"+var.getName() + ": (" + var.getColor());
        for (int color = 1; color < 5; color++) {
            if (checkAssignment(var, color)){
                var.setColor(color);
                //System.out.println(var.getName() + ": (" + var.getColor());
                //assignments.remove(var);
                Boolean success = simpleRecursiveBacktracking(assignments);
                if (success) return success;
                var.setColor(0);
                //assignments.add(var.getIndex(), var);
            }
        }

        return false;
        /*if (variablesList.isEmpty()) // Se todos os vértices foram pintados
            return true;
        if (variablesList.getFirst().getColor() == 0) { // Se ainda não recebeu um valor
            for (int color = 1; color < 5; color++) { // Para cada valor do domínio
                if (checkAssignment(variablesList.getFirst().getIndex(), color)) { // Se não existem cores adjacentes com essa cor
                    variablesList.getFirst().setColor(color); // Atribui essa cor
                    Region aux = variablesList.removeFirst(); // Remove essa região da lista de não coloridas
                    //LinkedList<Region> varAdj = new LinkedList<Region>(); // Cria uma nova lista ligada
                    variablesList.clear();
                    for (int i = 0; i < adjacencyList.get(aux.getIndex()).size(); i++){
                        variablesList.add(adjacencyList.get(aux.getIndex()).get(i)); // Adiciona os adjacentes de aux a nova lista
                    }
                    boolean success = simpleRecursiveBacktracking(varAdj); // Chama o método novamente para os próximos vértices
                    if (success) return true;   // Se deu certo retorna
                    aux.setColor(0);
                    variablesList.addFirst(aux);          // Se não, tenta com outro valor do domínio
                }
            }
            variablesList.removeFirst(); // Remove a variável que n deu certo
            return false;
        }
        variablesList.removeFirst(); // Remove a variável que n deu certo*/
    }

    public boolean checkAssignment(Vertex vertex, int color) {
        for (int i = 0; i < vertex.getE(); i++) { // Para cada vertice adjacente
            String edgeName = vertex.getEdges().get(i).getName(); // Copia o nome do vértice destino
            if (vertexes.stream().filter(s->s.getName().compareTo(edgeName) == 0).filter(s->s.color == color).count() != 0)
                return false;
        }
        return true;
    }

    public void printGraph(){
        for (int i = 0; i < V; i++) {
            vertexes.get(i).printVertex();
            System.out.print("\n");
        }
    }

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
