import java.util.Arrays;

public class MergeBU {

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
         
        /* precondition 
            assert isSorted(a, lo, mid);
            assert isSorted(a, mid + 1, hi);
        */

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else                            a[k] = aux[j++];
        }
        /* postcondition
            assert isSorted(a, lo, hi);
        */
    }

    public static void sort(Comparable[] a, int low, int hi){

        Comparable[] aux = new Comparable[hi];
        for(int sz = 1; sz < hi; sz = sz+sz) 
            for(int lo = low; lo < hi-sz; lo += sz+sz)
                MergeBU.merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, hi-1)); 
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args){
        Comparable[] numbers = {1, 5, 3, 8, 2, 6, 11, 10, 8, 9, 12, 1}; 
        MergeBU.sort(numbers, 0, numbers.length);   
        System.out.println(Arrays.toString(numbers));
    }
    
}
