package johnny.dsa.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeSerializationIterationTest {

    @Test
    public void testSerialize() {
        System.out.println("serializeBinaryTree");
        BinaryTreeSerializationIteration instance = new BinaryTreeSerializationIteration();

        assertEquals("", instance.serialize(null));

        TreeNode root2 = new TreeNode(1);
        assertEquals("1,#,#", instance.serialize(root2));

        TreeNode root3 = TreeNode.createInstance("1,2,3");
        assertEquals("1,2,#,#,3,#,#", instance.serialize(root3));

        TreeNode root4 = TreeNode.createInstance("1,2,3,#,#,4,#");
        assertEquals("1,2,#,#,3,4,#,#,#", instance.serialize(root4));

        TreeNode root5 = TreeNode.createInstance("1,2,3,#,#,4,5");
        assertEquals("1,2,#,#,3,4,#,#,5,#,#", instance.serialize(root5));

        TreeNode root6 = TreeNode.createInstance("1,2,3,4,5,6,7");
        assertEquals("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#", instance.serialize(root6));

        TreeNode root7 = TreeNode.createInstance("3,9,20,#,#,15,7");
        assertEquals("3,9,#,#,20,15,#,#,7,#,#", instance.serialize(root7));
    }

    @Test
    public void testDeserialize() {
        System.out.println("deserializeBinaryTree");
        BinaryTreeSerializationIteration instance = new BinaryTreeSerializationIteration();

        assertEquals(null, instance.deserialize(""));

        TreeNode expect2 = TreeNode.createInstance("1,#,#");
        TreeNode root2 = new TreeNode(1);
        TreeNode result2 = instance.deserialize(instance.serialize(root2));
        assertTrue(TreeNode.isSame(expect2, result2));

        TreeNode expect3 = TreeNode.createInstance("1,2,3");
        TreeNode root3 = TreeNode.createInstance("1,2,3");
        TreeNode result3 = instance.deserialize(instance.serialize(root3));
        assertTrue(TreeNode.isSame(expect3, result3));

        TreeNode expect4 = TreeNode.createInstance("1,2,3,#,#,4,#");
        TreeNode root4 = TreeNode.createInstance("1,2,3,#,#,4,#");
        TreeNode result4 = instance.deserialize(instance.serialize(root4));
        assertTrue(TreeNode.isSame(expect4, result4));

        TreeNode expect5 = TreeNode.createInstance("1,2,3,#,#,4,5");
        TreeNode root5 = TreeNode.createInstance("1,2,3,#,#,4,5");
        TreeNode result5 = instance.deserialize(instance.serialize(root5));
        assertTrue(TreeNode.isSame(expect5, result5));

        TreeNode expect6 = TreeNode.createInstance("1,2,3,4,5,6,7");
        TreeNode root6 = TreeNode.createInstance("1,2,3,4,5,6,7");
        TreeNode result6 = instance.deserialize(instance.serialize(root6));
        assertTrue(TreeNode.isSame(expect6, result6));

        TreeNode expect7 = TreeNode.createInstance("3,9,20,#,#,15,7");
        TreeNode root7 = TreeNode.createInstance("3,9,20,#,#,15,7");
        TreeNode result7 = instance.deserialize(instance.serialize(root7));
        assertTrue(TreeNode.isSame(expect7, result7));
    }
}
