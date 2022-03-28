import java.util.Arrays;

public class Bubble {

    public static void sort(Comparable[] a, int lo, int hi){

        for(int i = lo; i < hi; i++)
            for(int j = i+1; j < hi; j++)
                if(less(a[i], a[j])){
                    exch(a, i, j);
                } 
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args){
        Comparable[] numbers = {5, 3, 8, 2, 6, 8, 9, 10, 11, 12, 1};
        Bubble.sort(numbers, 0, numbers.length);      
        System.out.println(Arrays.toString(numbers));
    }
}