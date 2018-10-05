/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package johnny.dsa.mapreduce.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.common.Document;
import johnny.dsa.common.OutputCollector;
import johnny.dsa.mapreduce.TopKFrequentWords;

import static org.junit.Assert.*;

/**
 *
 * @author Johnny
 */
public class TopKFrequentWordsTest {
    
    public TopKFrequentWordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        System.out.println("testSomeMethod");
        Document doc1 = new Document();
        doc1.id = 1;
        doc1.content = "lintcode is the best online judge I love lintcode";
        
        Document doc2 = new Document();
        doc2.id = 2;
        doc2.content = "lintcode is an online judge for coding interview you can test your code online at lintcode";
        
        TopKFrequentWords.Map map = new TopKFrequentWords.Map();
        OutputCollector<String, Integer> output1 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect1 = new OutputCollector<String, Integer>();
        expect1.collect("lintcode", 1);
        expect1.collect("lintcode", 1);
        expect1.collect("is", 1);
        expect1.collect("the", 1);
        expect1.collect("best", 1);
        expect1.collect("online", 1);
        expect1.collect("judge", 1);
        expect1.collect("I", 1);
        expect1.collect("love", 1);

        map.map("", doc1, output1);
        assertTrue(OutputCollector.isSame(output1, expect1));
        
        TopKFrequentWords.Reduce reduce = new TopKFrequentWords.Reduce();
        reduce.setup(2);
        
        Iterator<Map.Entry<String, List<Integer>>> it1 = output1.map.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, List<Integer>> entry =it1.next();
            reduce.reduce(entry.getKey(), entry.getValue().iterator());
        }
        
        OutputCollector<String, Integer> output2 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect2 = new OutputCollector<String, Integer>();
        expect2.collect("lintcode", 2);
        expect2.collect("I", 1);
        reduce.cleanup(output2);
        assertTrue(OutputCollector.isSame(output2, expect2));
    }
    
    @Test
    public void testSomeMethod2() {
        System.out.println("testSomeMethod2");
        Document doc1 = new Document();
        doc1.id = 1;
        doc1.content = "This is  the content of document1";
        
        Document doc2 = new Document();
        doc2.id = 2;
        doc2.content = "This is the       content of document3";
        
        TopKFrequentWords.Map map = new TopKFrequentWords.Map();
        OutputCollector<String, Integer> output1 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect1 = new OutputCollector<String, Integer>();
        expect1.collect("This", 1);
        expect1.collect("This", 1);
        expect1.collect("is", 1);
        expect1.collect("is", 1);
        expect1.collect("the", 1);
        expect1.collect("the", 1);
        expect1.collect("content", 1);
        expect1.collect("content", 1);
        expect1.collect("of", 1);
        expect1.collect("of", 1);
        expect1.collect("document1", 1);
        expect1.collect("document3", 1);

        map.map("", doc1, output1);
        map.map("", doc2, output1);
        assertTrue(OutputCollector.isSame(output1, expect1));
        
        TopKFrequentWords.Reduce reduce = new TopKFrequentWords.Reduce();
        reduce.setup(3);
        
        Iterator<Map.Entry<String, List<Integer>>> it1 = output1.map.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, List<Integer>> entry = it1.next();
            reduce.reduce(entry.getKey(), entry.getValue().iterator());
        }
        
        OutputCollector<String, Integer> output2 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect2 = new OutputCollector<String, Integer>();
        expect2.collect("This", 2);
        expect2.collect("content", 2);
        expect2.collect("is", 2);
        reduce.cleanup(output2);
        assertTrue(OutputCollector.isSame(output2, expect2));
    }
    
    @Test
    public void testSomeMethod3() {
        System.out.println("testSomeMethod3");
        Document doc1 = new Document();
        doc1.id = 1;
        doc1.content = "tt gc gc ba ba";
        
        Document doc2 = new Document();
        doc2.id = 2;
        doc2.content = "wz gc gc ba ba";
        
        TopKFrequentWords.Map map = new TopKFrequentWords.Map();
        OutputCollector<String, Integer> output1 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect1 = new OutputCollector<String, Integer>();
        expect1.collect("tt", 1);
        expect1.collect("gc", 1);
        expect1.collect("gc", 1);
        expect1.collect("ba", 1);
        expect1.collect("ba", 1);
        expect1.collect("wz", 1);
        expect1.collect("ba", 1);
        expect1.collect("ba", 1);
        expect1.collect("gc", 1);
        expect1.collect("gc", 1);

        map.map("", doc1, output1);
        map.map("", doc2, output1);
        assertTrue(OutputCollector.isSame(output1, expect1));
        
        TopKFrequentWords.Reduce reduce = new TopKFrequentWords.Reduce();
        reduce.setup(2);
        
        Iterator<Map.Entry<String, List<Integer>>> it1 = output1.map.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, List<Integer>> entry = it1.next();
            reduce.reduce(entry.getKey(), entry.getValue().iterator());
        }
        
        OutputCollector<String, Integer> output2 = new OutputCollector<String, Integer>();
        OutputCollector<String, Integer> expect2 = new OutputCollector<String, Integer>();
        expect2.collect("ba", 4);
        expect2.collect("gc", 4);
        reduce.cleanup(output2);
        assertTrue(OutputCollector.isSame(output2, expect2));
    }
}
