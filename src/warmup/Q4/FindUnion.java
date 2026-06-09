package warmup.Q4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * A utility class designed to find the mathematical union of two sets.
 */
public class FindUnion {

    /**
     * Finds the union of two integer arrays.
     * The union is defined as the combined collection of all unique integers from both setA and setB.
     * If a number appears in both input arrays, it must only appear ONCE in the result.
     * * Note: You may assume that the input arrays are valid mathematical sets.
     * This means there are no duplicate numbers within setA itself, nor within setB itself.
     * The order of the integers in the returned array does not matter.
     *
     * @param setA the first set of unique integers
     * @param setB the second set of unique integers
     * @return a new int[] containing all unique numbers from both sets combined
     */
    public static int[] find(int[] setA, int[] setB) {
        // TODO: Implement the union logic based on the documentation above.
        Set<Integer> set = new HashSet<>();
        for(int ia: setA){
            set.add(ia);
        }
        for(int ib: setB){
            set.add(ib);
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

        return result;
        // Replace this line
    }
}

