package johnny.datastructure.graph;

public class Vertex implements Comparable {
    public int index;
    public String label;
    public boolean visited;

    public Vertex(int index, String label) {
        this.index = index;
        this.label = label;
        this.visited = false; 
    }

    @Override
    public String toString() {
        return label;
    }
    
    @Override
    public int compareTo(Object other) {
    		return this.index - ((Vertex)other).index;
    }
}
