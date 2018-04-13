package johnny.datastructure.graph;

public class Node {
    public String name;
    public boolean visited;
    public Node[] neighbors;

    public Node(String name) {
        this.name = name;
        this.visited = false;
    }
    
    public void setNeighbors(Node[] neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "name:" + name  + " neighbors:" + neighbors;
    }
}
