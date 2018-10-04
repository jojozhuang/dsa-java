package johnny.dsa.trie.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.trie.Trie;

public class TrieTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testInsert() {
        System.out.println("testInsert");
        Trie instance = new Trie();
        instance.insert("dot");
        instance.insert("dog");
        instance.insert("fog");
        assertEquals(true, instance.search("fog"));
        assertEquals(false, instance.search("foggy"));
        instance.insert("foggy");
        assertEquals(true, instance.search("foggy"));
    }

    @Test
    public void testSearch() {
        System.out.println("testSearch");
        Trie instance = new Trie();
        instance.insert("dot");
        instance.insert("dog");
        instance.insert("fat");
        instance.insert("full");
        instance.insert("apple");
        assertEquals(true, instance.search("fat"));
        assertEquals(false, instance.search("fit"));
        assertEquals(true, instance.search("dog"));
        assertEquals(false, instance.search("tog"));
    }

    @Test
    public void testStartsWith() {
        System.out.println("testStartsWith");
        Trie instance = new Trie();
        instance.insert("dot");
        instance.insert("dog");
        instance.insert("fat");
        instance.insert("full");
        instance.insert("apple");
        assertEquals(true, instance.startsWith("do"));
        assertEquals(false, instance.startsWith("dow"));
        assertEquals(true, instance.startsWith("f"));
        assertEquals(false, instance.startsWith("ac"));
        assertEquals(false, instance.startsWith("apq"));
    }

    @Test
    public void testDelete() {
        System.out.println("testDelete");
        Trie instance = new Trie();
        instance.insert("dot");
        instance.insert("dog");
        instance.insert("pump");
        instance.insert("fat");
        instance.insert("fire");
        instance.insert("do");
        assertEquals(true, instance.search("fat"));
        assertEquals(false, instance.search("fit"));
        assertEquals(true, instance.search("dog"));
        assertEquals(false, instance.search("tog"));
        assertEquals(true, instance.search("dot"));
        assertEquals(true, instance.search("do"));
        assertEquals(false, instance.delete("aaa"));
        assertEquals(true, instance.delete("do"));
        assertEquals(false, instance.search("do"));
        assertEquals(true, instance.delete("dot"));
        assertEquals(false, instance.search("dot"));
        assertEquals(true, instance.search("pump"));
        assertEquals(true, instance.delete("pump"));
        assertEquals(false, instance.search("pump"));
    }
}
