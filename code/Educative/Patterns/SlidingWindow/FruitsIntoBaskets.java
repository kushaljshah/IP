package Educative.Patterns.SlidingWindow;

import java.util.*;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * Example 4:
 *
 * Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can pick from trees [1,2,1,1,2].
 */

public class FruitsIntoBaskets {

    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[] {0,1}));
        System.out.println(totalFruitWithFirstIndex(new int[] {0,1}));
        System.out.println(totalFruitWithFirstIndex(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(totalFruitWithFirstIndex(new int[] {1,2,3,2,2}));
        System.out.println(totalFruitWithFirstIndex(new int[] {1,0,1,4,1,4,1,2,3}));

    }

    public static int totalFruitWithFirstIndex(int[] fruits) {
        if(fruits == null || fruits.length == 0)
            return 0;

        Map<Integer, Integer> uniqueElements = new LinkedHashMap<>();
        int firstIndex = 0;
        int maxTrees = 0;
        int currentTrees = 0;

        for(int i =0; i<fruits.length; i++){
            uniqueElements.put(fruits[i], uniqueElements.getOrDefault(fruits[i], 0) + 1);
            currentTrees++;
            while (uniqueElements.size() > 2){
                uniqueElements.put(fruits[firstIndex], uniqueElements.getOrDefault(fruits[firstIndex], 0) - 1);
                if(uniqueElements.get(fruits[firstIndex]) == 0)
                    uniqueElements.remove(fruits[firstIndex]);

                firstIndex++;
                currentTrees--;
            }

            if(currentTrees > maxTrees)
                maxTrees = currentTrees;
        }

        return maxTrees;

    }

    public static int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0)
            return 0;

        Map<Integer, Integer> uniqueElements = new LinkedHashMap<>();
        int maxTrees = 0;
        int currentTrees = 0;
        for(int i =0; i<fruits.length; i++){

            if(i > 0 && fruits[i] == fruits[i-1])
                uniqueElements.put(fruits[i], uniqueElements.getOrDefault(fruits[i], 0) + 1);
            else
                uniqueElements.put(fruits[i], 1);

            currentTrees++;
            if(uniqueElements.size() > 2){
                Map.Entry<Integer, Integer> entry = uniqueElements.entrySet().stream().findFirst().get();
                if(entry.getKey() == fruits[i - 1]) {
                    entry = uniqueElements.entrySet().stream().skip(1).findFirst().get();
                }

                uniqueElements.remove(entry.getKey());
                currentTrees=uniqueElements.entrySet().stream().findFirst().get().getValue() + 1;
            }

            if(currentTrees > maxTrees)
                maxTrees = currentTrees;

        }

        return maxTrees;
    }

}
