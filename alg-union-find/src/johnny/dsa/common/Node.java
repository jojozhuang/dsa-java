package johnny.dsa.common;

public class Node {
    public String name;
    public boolean visited;
    public Node[] neighbors;

    public Node(String name) {
        this.name = name;
        this.visited = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
