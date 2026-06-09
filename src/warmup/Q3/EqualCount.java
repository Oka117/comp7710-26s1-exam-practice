// collected from
// https://gitlab.comp.anu.edu.au/comp1110/extra/comp1110-exam-2022s2/-/blob/main/src/comp1110/exam/EqualCount.java

package warmup.Q3;

public class EqualCount {

    /**
     * Count the number of positions where the elements of two arrays
     * of Strings are equal.
     *
     * For example, if one array is {"yes", "blue", "no"} and the other
     * is {"maybe", "red", "no"}, the count is 1, because the arrays
     * are equal only in position 2.
     *
     * If the two arrays are not the same size, the method should return
     * -1. If either of the two arrays are null, or contain null elements,
     * the method will throw a NullPointerException.
     *
     * @param a An array of Strings; must not be null.
     * @param b An array of Strings, of the same length as a; must not
     * be null.
     * @return The number of positions in 0 .. a.length - 1 where
     * a and b are equal.
     */
    public static int equalCount(String[] a, String[] b) {
        // Note: this is not a correct implementation of the method.
        if(a == null || b == null) throw new NullPointerException();
        if(a.length != b.length) return -1;

        for(String s : a){
            if(s == null) throw new NullPointerException();
        }
        for(String s : b){
            if(s == null) throw new NullPointerException();
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || b[i] == null) {
                throw new NullPointerException();
            }

            if (a[i].equals(b[i])) {
                count++;
            }
        }
        return count;
    }

}
