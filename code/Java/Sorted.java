package Java;

import java.util.*;

public class Sorted {

    public static void main(String[] args) {
        SortedMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        SortedMap<Integer, Integer> map1 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        SortedSet<Map.Entry<String, Double>> sortedset = new TreeSet<Map.Entry<String, Double>>(
                new Comparator<Map.Entry<String, Double>>() {
                    @Override
                    public int compare(Map.Entry<String, Double> e1,
                                       Map.Entry<String, Double> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });

//        sortedset.addAll(myMap.entrySet());


        SortedSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
