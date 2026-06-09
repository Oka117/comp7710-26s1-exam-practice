// collected from
// https://gitlab.comp.anu.edu.au/comp1110/extra/comp1110-exam-2022s1/-/blob/master/src/comp1110/exam/Q1Larger.java

package warmup.Q1;


public class FindLargest {
    /**
     * Given an array of integers and a start and end value, return the largest value in the array
     * that is outside the range from start to end inclusive.
     *
     * If the range is invalid, i.e. start is greater than end, return start.
     *
     * If there is no value outside the range, return end.
     *
     * For example:
     *
     * If I have the array of ints: [10,3,2,20], start value 4 and end value 20, this will return 3
     * because 3 is the largest value that is outside the range 4 to 20.
     *
     * Note: start and end are values **not** indices.
     * @param in    an array of integers.
     * @param start the start value of the range (inclusive).
     * @param end   the end value of the range (inclusive).
     * @return the largest value outside the range from start to end, or start if the start is
     * greater than end, or end if there is no such value outside the range.
     */
    public static int findLargest(int[] in, int start, int end) {
        if(start > end) return start;
        int min = 0;
        for(int i : in){
            if(min > i) min = i;
        }
        int max = min;
        for(int i : in){
            if(i < start || i > end) {
                if (i > max) {
                    max = i;
                }
            }
        }

        return max == min ? end : max;

       // FIXME complete this method
    }
}
