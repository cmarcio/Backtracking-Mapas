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
    int remainingColors[];

    Vertex(String name, int index) {
        this.name = name;
        color = 0;
        this.index = index;
        remainingColors = new int[5];
        for (int i = 0; i < 5; i++)
            remainingColors[i] = 1;
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

    public int getE() {
        return E;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getIndex() {
        return index;
    }

    public boolean isValidColor(int color) {
        return remainingColors[color] == 1;
    }

    public void setColorValid(int color){
        remainingColors[color] = 1;
    }

    public  void setColorInvalid(int color){
        remainingColors[color] = 0;
    }

    public boolean isOnlyRemainingColor(int color){
        for (int i = 1; i < 5; i++){
            if ((i != color && isValidColor(i)) || (i == color && !isValidColor(color)))
                return false;
        }
        return true;
    }

    public int getNumberOfRemainingColors() {
        int sum = 0;
        for (int i = 1; i < 5; i++)
            sum = sum + i;
        return sum;
    }
}
