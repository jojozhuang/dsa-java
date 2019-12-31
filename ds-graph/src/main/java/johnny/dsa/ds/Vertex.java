package johnny.dsa.ds;

public class Vertex {
    public int index;
    public String name;
    public boolean visited;

    public Vertex(int index, String name) {
        this.index = index;
        this.name = name;
        this.visited = false; 
    }

    @Override
    public String toString() {
        return name;
    }
}
