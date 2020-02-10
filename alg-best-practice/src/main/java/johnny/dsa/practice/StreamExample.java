package johnny.dsa.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // #1. Convert character list to string
        List<Character> list = Arrays.asList('J','o','h','n','n','y');
        String str = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        //str = "Johnny"

        // #2. Convert map to list
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 2);
        map.put("Orange", 5);
        map.put("Watermelon", 3);

        List<String> list2 = map.entrySet().stream()
                                .map(x -> (x.getKey() + " " + x.getValue()))
                                .collect(Collectors.toList());

        // list2 = {"Apple 2", "Orange 5", "Watermelon 3"}

        // #3. Find sum of array
        int [] arr = {1,2,3,4};
        int sum = Arrays.stream(arr).sum();

        // sum = 10

        // #4. Find sum of integer list
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum2 = integers.stream()
                               .reduce(0, (a, b) -> a + b);

        Integer sum3 = integers.stream()
                               .reduce(0, Integer::sum);

        // #5. Convert list of integer to array of int
        List<Integer> list3 = Arrays.asList(1,2,3,4,5);
        int[] primitive = list3.stream()
                               .mapToInt(Integer::intValue)
                               .toArray();
        // primitive = [1,2,3,4,5];

        // Handle null with default value
        List<Integer> list4 = Arrays.asList(1,null,3,4,5);
        int[] primitive2 = list4.stream()
                                .mapToInt(i->(i == null ? 0 : i))
                                .toArray();
        // primitive2 = [1,0,3,4,5];

        // #6. Convert List of String to array of String.
        List<String> list5 = Arrays.asList("Hello", "Johnny", "Welcome");
        String[] array = list5.stream().toArray(String[]::new);
        // array = ["Hello", "Johnny", "Welcome"];
    }
}
