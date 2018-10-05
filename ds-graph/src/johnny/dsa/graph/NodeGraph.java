package johnny.dsa.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import johnny.dsa.common.Node;

/*
 * A graph, implemented using a neighbor list.
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

    // dfs, stack
    private Stack<Node> stack = new Stack<Node>();
    public String[] dfs(Node root) {
        String[] res = new String[nodes.length];
        if (root == null) {
            return res;
        }
        root.visited = true;
        int idx = 0;
        res[idx++] = root.name;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            Node neighbor = getUnvisitedNeighbor(node);
            if (neighbor == null) {
                stack.pop();
            } else {
                neighbor.visited = true;
                res[idx++] = neighbor.name;
                stack.push(neighbor);
            }
        }

        return res;
    }
    private Node getUnvisitedNeighbor(Node node) {
        for (int i = 0; i < node.neighbors.length; i++) {
            if (node.neighbors[i].visited == false) {
                return node.neighbors[i];
            }
        }
        return null;
    }

    // dfs, recursion
    public void dfs2(Node root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(root.name);
        root.visited = true;
        for (Node neighbor : root.neighbors) {
            if (neighbor.visited == false) {
                dfs2(neighbor, list);
            }
        }
    }

    // bfs
    private Queue<Node> queue = new LinkedList<Node>();
    public String[] bfs(Node root) {
        String[] res = new String[nodes.length];
        if (root == null) {
            return res;
        }
        root.visited = true;
        int idx = 0;
        res[idx++] = root.name;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (neighbor.visited == false) {
                    neighbor.visited = true;
                    res[idx++] = neighbor.name;
                    queue.offer(neighbor);
                }
            }
        }
        
        return res;
    }
}
