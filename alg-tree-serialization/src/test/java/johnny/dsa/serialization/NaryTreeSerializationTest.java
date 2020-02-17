package johnny.dsa.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaryTreeSerializationTest {

    @Test
    public void testSerialize() {
        System.out.println("serializeNaryTree");
        NaryTreeSerialization instance = new NaryTreeSerialization();

        assertEquals("", instance.serialize(null));

        NaryNode root2 = new NaryNode(1);
        assertEquals("1,0", instance.serialize(root2));

        NaryNode root3 = NaryNode.createInstance("1,1,4,0");
        assertEquals("1,1,4,0", instance.serialize(root3));

        NaryNode root4 = NaryNode.createInstance("1,2,2,0,3,0");
        assertEquals("1,2,2,0,3,0", instance.serialize(root4));

        NaryNode root5 = NaryNode.createInstance("1,3,3,2,5,0,6,0,2,0,4,0");
        assertEquals("1,3,3,2,5,0,6,0,2,0,4,0", instance.serialize(root5));
    }

    @Test
    public void testDeserialize() {
        System.out.println("deserializeNaryTree");
        NaryTreeSerialization instance = new NaryTreeSerialization();

        assertEquals(null, instance.deserialize(""));

        NaryNode expect2 = NaryNode.createInstance("1,0");
        NaryNode root2 = new NaryNode(1);
        NaryNode result2 = instance.deserialize(instance.serialize(root2));
        assertTrue(NaryNode.isSame(expect2, result2));

        NaryNode expect3 = NaryNode.createInstance("1,1,4,0");
        NaryNode root3 = NaryNode.createInstance("1,1,4,0");
        NaryNode result3 = instance.deserialize(instance.serialize(root3));
        assertTrue(NaryNode.isSame(expect3, result3));

        NaryNode expect4 = NaryNode.createInstance("1,2,2,0,3,0");
        NaryNode root4 = NaryNode.createInstance("1,2,2,0,3,0");
        NaryNode result4 = instance.deserialize(instance.serialize(root4));
        assertTrue(NaryNode.isSame(expect4, result4));

        NaryNode expect5 = NaryNode.createInstance("1,3,3,2,5,0,6,0,2,0,4,0");
        NaryNode root5 = NaryNode.createInstance("1,3,3,2,5,0,6,0,2,0,4,0");
        NaryNode result5 = instance.deserialize(instance.serialize(root5));
        assertTrue(NaryNode.isSame(expect5, result5));
    }
}
