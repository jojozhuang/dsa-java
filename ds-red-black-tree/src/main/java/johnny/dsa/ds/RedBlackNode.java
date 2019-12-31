package johnny.dsa.ds;

public class RedBlackNode {
    public int val;
    public int color; // 0: black; 1: red
    public RedBlackNode left, right;

    public RedBlackNode(int value) {
        this(value, null, null);
    }

    public RedBlackNode(int value, RedBlackNode lt, RedBlackNode rt)
    {
        this.val = value;
        left = lt;
        right = rt;
        color = 1;
    }

}
