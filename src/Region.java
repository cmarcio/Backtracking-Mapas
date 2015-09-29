import java.util.ArrayList;

/**
 * Created by Marcio on 29/09/2015.
 */
public class Region {
    private String name;
    private int color;
    private int index;
    private ArrayList<String> edges;

    Region(String name) {
        this.name = name;
        this.color = 0;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setIndex(int i){
        index = i;
    }

    public int getIndex() {
        return index;
    }
}
