package johnny.dsa.skiplist;

public class SkipListExample {
    public static void main( String[] args ) {
        SkipList list = new SkipList();
        list.insert(5);
        list.insert(10);
        list.insert(9);
        list.insert(8);
        list.insert(12);
        list.insert(1);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(90);

        list.print();
        SkipNode node = list.search(9);
        System.out.println(node.val);
        //list.printAllLevel();

        list.delete(10);
        list.delete(1);
        list.print();
        //list.printAllLevel();
    }
}
