package johnny.dsa.ds;

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
    
    public static List<int[]> buildList2(int[][] array) {
        List<int[]> res = new ArrayList<int[]>();
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
}
