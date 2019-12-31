package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniquePathTest {

    @Test
    public void testUniquePathMatrix() {
        System.out.println("testUniquePathMatrix");
        UniquePath instance = new UniquePath();
        
        assertEquals(0, instance.uniquePathMatrix(0, 0));
        assertEquals(1, instance.uniquePathMatrix(1, 1));
        assertEquals(1, instance.uniquePathMatrix(3, 1));
        assertEquals(1, instance.uniquePathMatrix(1, 4));
        assertEquals(2, instance.uniquePathMatrix(2, 2));
        assertEquals(3, instance.uniquePathMatrix(3, 2));
        assertEquals(3, instance.uniquePathMatrix(2, 3));
        assertEquals(6, instance.uniquePathMatrix(3, 3));
        assertEquals(86493225, instance.uniquePathMatrix(19, 13));
        
        assertEquals(0, instance.uniquePathMatrix2(0, 0));
        assertEquals(1, instance.uniquePathMatrix2(1, 1));
        assertEquals(1, instance.uniquePathMatrix2(3, 1));
        assertEquals(1, instance.uniquePathMatrix2(1, 4));
        assertEquals(2, instance.uniquePathMatrix2(2, 2));
        assertEquals(3, instance.uniquePathMatrix2(3, 2));
        assertEquals(3, instance.uniquePathMatrix2(2, 3));
        assertEquals(6, instance.uniquePathMatrix2(3, 3));
        assertEquals(86493225, instance.uniquePathMatrix2(19, 13));
    }
    
    @Test
    public void testUniquePathArray() {
        System.out.println("testUniquePathArray");
        UniquePath instance = new UniquePath();
        
        assertEquals(0, instance.uniquePathArray(0, 0));
        assertEquals(1, instance.uniquePathArray(1, 1));
        assertEquals(1, instance.uniquePathArray(3, 1));
        assertEquals(1, instance.uniquePathArray(1, 4));
        assertEquals(2, instance.uniquePathArray(2, 2));
        assertEquals(3, instance.uniquePathArray(3, 2));
        assertEquals(3, instance.uniquePathArray(2, 3));
        assertEquals(6, instance.uniquePathArray(3, 3));
        assertEquals(86493225, instance.uniquePathArray(19, 13));
        
        assertEquals(0, instance.uniquePath(0, 0));
        assertEquals(1, instance.uniquePath(1, 1));
        assertEquals(1, instance.uniquePath(3, 1));
        assertEquals(1, instance.uniquePath(1, 4));
        assertEquals(2, instance.uniquePath(2, 2));
        assertEquals(3, instance.uniquePath(3, 2));
        assertEquals(3, instance.uniquePath(2, 3));
        assertEquals(6, instance.uniquePath(3, 3));
        assertEquals(86493225, instance.uniquePath(19, 13));
    }
}
