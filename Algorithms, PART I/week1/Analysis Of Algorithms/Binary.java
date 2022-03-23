public class Binary {
    
    public static int search(int[] a, int key){

        int low = 0, high = a.length-1;

        while(low <= high){
            int middle = low + (high - low) / 2;
            if(key < a[middle]) high = middle - 1;
            else if(key > a[middle]) high = middle + 1;
            else return middle;
        }
        
        return -1;
    }

}


