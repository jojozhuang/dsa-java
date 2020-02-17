package johnny.dsa.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeSerializationTest {

    @Test
    public void testSerialize() {
        System.out.println("serializeBinarySearchTree");
        BinarySearchTreeSerialization instance = new BinarySearchTreeSerialization();

        assertEquals("#", instance.serialize(null));

        TreeNode root2 = new TreeNode(1);
        assertEquals("1", instance.serialize(root2));

        TreeNode root3 = TreeNode.createInstance("5,3,6,2,4,#,7");
        assertEquals("5,3,2,4,6,7", instance.serialize(root3));
    }

    @Test
    public void testDeserialize() {
        System.out.println("deserializeBinarySearchTree");
        BinarySearchTreeSerialization instance = new BinarySearchTreeSerialization();

        assertEquals(null, instance.deserialize(""));

        TreeNode expect1 = TreeNode.createInstance("5,3,6,2,4,#,7");
        TreeNode result1 = instance.deserialize("5,3,2,4,6,7");
        assertTrue(TreeNode.isSame(expect1, result1));
    }
}
