package johnny.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * A graph, implemented using an neighbor nodes.
 */
public class NodeGraph {
    public Node[] nodes;

    public NodeGraph(int size)
    {
        nodes = new Node[size];
    }

    public void addNeighbors(int index, Node[] neighbors) {
        nodes[index].neighbors = neighbors;
    }

    public void displayNode(Node node) {
        System.out.print(node.name);
    }

    // dfs
    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        displayNode(root);
        root.visited = true;
        for(Node neighbor : root.neighbors) {
            if (neighbor.visited == false) {
                dfs(neighbor);
            }
        }
    }

    // bfs
    private Queue<Node> queue = new LinkedList<Node>();
    public void bfs(Node root) {
        if (root == null) {
            return;
        }
        root.visited = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            displayNode(node);
            for (Node neighbor : node.neighbors) {
                if (neighbor.visited == false) {
                    neighbor.visited = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
