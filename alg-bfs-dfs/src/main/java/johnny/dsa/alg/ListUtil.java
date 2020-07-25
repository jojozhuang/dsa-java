package johnny.dsa.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListUtil {
    public static <T> List<List<T>> buildList2(T[][] array) {
        List<List<T>> res = new ArrayList<List<T>>();
        if (array == null || array.length == 0) {
            return res;
        }
        for (int i = 0; i < array.length; i++) {
            res.add(buildList(array[i]));
        }
        return res;
    }

    public static <T> List<T> buildList(T[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<T>();
        }
        //return Arrays.asList(array); // return unmodifiable list.
        return new LinkedList<>(Arrays.asList(array)); // return modifiable list.
    }

    public static List<int[]> buildListOfIntArray(int[][] array) {
        List<int[]> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        for (int i = 0; i < array.length; i++) {
            int[] elem = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                elem[j] = array[i][j];
            }
            res.add(elem);
        }
        return res;
    }

    public static <T> boolean equalsIgnoreOrder(List<T> list1, List<T> list2) {
        boolean res = equalsIgnoreOrderPrint(list1, list2);
        if (res == false) {
            println("Expect List:");
            list1.stream().forEach(val -> System.out.print(val + ","));
            println("");
            println("Actual List:");
            list2.stream().forEach(val -> System.out.print(val + ","));
        }
        return res;
    }

    private static <T> boolean equalsIgnoreOrderPrint(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null){
            return true;
        }

        if((list1 == null && list2 != null)
                || list1 != null && list2 == null
                || list1.size() != list2.size()){
            return false;
        }

        return (list1.containsAll(list2) && list2.containsAll(list1));
    }

    private static void println(String msg) {
        System.out.println(msg);
    }
    private static void print(String msg) {
        System.out.print(msg);
    }
    /*
    public static <T extends Comparable> boolean equalLists(List<T> list1, List<T> list2){
        if (list1 == null && list2 == null){
            return true;
        }

        if((list1 == null && list2 != null)
          || list1 != null && list2 == null
          || list1.size() != list2.size()){
            return false;
        }

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
        list1 = new ArrayList<T>(list1);
        list2 = new ArrayList<T>(list2);

        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }
    */
}
