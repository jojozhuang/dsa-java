package johnny.dsa.ds;

import java.util.*;

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
    public List<String> dfs(Node root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<Node>();
        root.visited = true;
        ans.add(root.name);
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            Node neighbor = getUnvisitedNeighbor(node);
            if (neighbor == null) {
                stack.pop();
            } else {
                neighbor.visited = true;
                ans.add(neighbor.name);
                stack.push(neighbor);
            }
        }

        return ans;
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
    public List<String> bfs(Node root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<Node>();
        root.visited = true;
        ans.add(root.name);
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (neighbor.visited == false) {
                    neighbor.visited = true;
                    ans.add(neighbor.name);
                    queue.offer(neighbor);
                }
            }
        }
        
        return ans;
    }
}
