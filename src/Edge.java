/**
 * Created by Marcio on 29/09/2015.
 */
public class Edge {
    String name;

    Edge(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printEdge(){
        System.out.print("["+name+"]");
    }


}
