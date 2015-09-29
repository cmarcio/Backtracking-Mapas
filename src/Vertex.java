import java.util.ArrayList;

/**
 * Created by Marcio on 29/09/2015.
 */
public class Vertex {
    String name;
    int color;
    int index;
    ArrayList<Edge> edges;
    int E;

    Vertex(String name, int index) {
        this.name = name;
        color = 0;
        this.index = index;
    }

    public void addEdges(int E, String[] names){
        this.E = E;
        edges = new ArrayList<>(E);
        for(int i = 0; i < E; i++) {
            edges.add(i, new Edge(names[i]));
        }
    }

    public void printVertex(){
        System.out.print("("+name+")");
        for (int i = 0; i < E; i++)
            edges.get(i).printEdge();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
