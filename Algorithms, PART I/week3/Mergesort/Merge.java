import java.util.Arrays;

public class Merge {

    private static final int CUTOFF = 7;

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

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

         
        /*if(hi <= lo + CUTOFF - 1){
            Insertion.sort(a, lo, hi);
            return;
        }*/
        if(lo < hi){
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid+1, hi);
            if(!less(a[mid+1], a[mid])) return;
            merge(a, aux, lo, mid, hi);
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args){
        Comparable[] numbers = {1, 5, 3, 8, 2, 6, 11, 10, 8, 9, 12, 1}; 
        Comparable[] aux = new Comparable[numbers.length];
        Merge.sort(numbers, aux, 0, numbers.length-1);   
        System.out.println(Arrays.toString(numbers));
    }
}
