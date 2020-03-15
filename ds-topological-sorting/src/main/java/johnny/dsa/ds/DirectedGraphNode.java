package johnny.dsa.ds;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}