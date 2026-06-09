package warmup.Q4;

import java.util.HashSet;
import java.util.Set;

/**
 * A utility class designed to find the mathematical intersection of two sets.
 */
public class FindIntersect {

    /**
     * Finds the intersection of two integer arrays.
     * The intersection is defined as the collection of integers that appear in BOTH setA and setB.
     * * Note: You may assume that the input arrays are valid mathematical sets.
     * This means there are no duplicate numbers within setA itself, nor within setB itself.
     * The order of the integers in the returned array does not matter.
     *
     * @param setA the first set of unique integers
     * @param setB the second set of unique integers
     * @return a new int[] containing only the numbers present in both setA and setB
     */
    public static int[] find(int[] setA, int[] setB) {
        // TODO: Implement the intersection logic based on the documentation above.

        Set<Integer> set = new HashSet<>();
        for(int ia: setA){
            for(int ib: setB){
                if(ia == ib) set.add(ib);
            }
        }

        int len = set.size();
        int count = 0;
        int[] result = new int[len];
        while(count < len){
            for(int i : set){
                result[count] = i;
                count++;
            }
        }

        return result; // Replace this line
    }
}

