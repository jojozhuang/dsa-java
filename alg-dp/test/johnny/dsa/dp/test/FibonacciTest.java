package johnny.dsa.dp.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.dp.Fibonacci;

public class FibonacciTest {

    @Test
    public void testFibonacciRecursive() {
        System.out.println("testFibonacciRecursive");
        Fibonacci instance = new Fibonacci();
        
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
        assertEquals(0, instance.fibonacciRecursive(0));
        assertEquals(1, instance.fibonacciRecursive(1));
        assertEquals(1, instance.fibonacciRecursive(2));
        assertEquals(2, instance.fibonacciRecursive(3));
        assertEquals(3, instance.fibonacciRecursive(4));
        assertEquals(5, instance.fibonacciRecursive(5));
        assertEquals(8, instance.fibonacciRecursive(6));
        assertEquals(13, instance.fibonacciRecursive(7));
        assertEquals(21, instance.fibonacciRecursive(8));
        assertEquals(34, instance.fibonacciRecursive(9));
        assertEquals(55, instance.fibonacciRecursive(10));
        assertEquals(89, instance.fibonacciRecursive(11));
        assertEquals(144, instance.fibonacciRecursive(12));
        assertEquals(233, instance.fibonacciRecursive(13));
    }
    
    @Test
    public void testFibonacciDP() {
        System.out.println("testFibonacciDP");
        Fibonacci instance = new Fibonacci();

        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
        assertEquals(0, instance.fibonacciDP(0));
        assertEquals(1, instance.fibonacciDP(1));
        assertEquals(1, instance.fibonacciDP(2));
        assertEquals(2, instance.fibonacciDP(3));
        assertEquals(3, instance.fibonacciDP(4));
        assertEquals(5, instance.fibonacciDP(5));
        assertEquals(8, instance.fibonacciDP(6));
        assertEquals(13, instance.fibonacciDP(7));
        assertEquals(21, instance.fibonacciDP(8));
        assertEquals(34, instance.fibonacciDP(9));
        assertEquals(55, instance.fibonacciDP(10));
        assertEquals(89, instance.fibonacciDP(11));
        assertEquals(144, instance.fibonacciDP(12));
        assertEquals(233, instance.fibonacciDP(13));
    }
    
    @Test
    public void testSearchTemplate() {
        System.out.println("testSearchTemplate");
        Fibonacci instance = new Fibonacci();

        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
        assertEquals(0, instance.fibonacci(0));
        assertEquals(1, instance.fibonacci(1));
        assertEquals(1, instance.fibonacci(2));
        assertEquals(2, instance.fibonacci(3));
        assertEquals(3, instance.fibonacci(4));
        assertEquals(5, instance.fibonacci(5));
        assertEquals(8, instance.fibonacci(6));
        assertEquals(13, instance.fibonacci(7));
        assertEquals(21, instance.fibonacci(8));
        assertEquals(34, instance.fibonacci(9));
        assertEquals(55, instance.fibonacci(10));
        assertEquals(89, instance.fibonacci(11));
        assertEquals(144, instance.fibonacci(12));
        assertEquals(233, instance.fibonacci(13));
    }
}
