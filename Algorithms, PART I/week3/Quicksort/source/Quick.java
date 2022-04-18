package source;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {

    private static final int CUTOFF = 10;

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
 
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;
            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;

            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
       /* if (hi <= lo + CUTOFF -1){
            Insertion.sort(a, lo, hi);
            return;
        } */

        if(hi <= lo) return;

       /* int m = medianOf3(a, lo, lo + (hi - lo)/2, hi);
        exch(a, lo, m); */

        int j = partition(a, lo, hi);
        //sort(a, lo, j+1);
        //sort(a, j+1, hi);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;

        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return a[k];
        }
        return a[k];
    }

    public static void main(String[] args){
        Comparable[] numbers = {1, 5, 3, 8, 2, 6, 11, 10, 8, 9, 12, 1};
        //StdRandom.shuffle(numbers); 
        Quick.sort(numbers, 0, numbers.length-1);   
        System.out.println(Arrays.toString(numbers));
    }
}
