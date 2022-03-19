public class BinarySearch {

    private int key;
    private int[] values;

    public BinarySearch(int key, int[] values){
        this.key = key;
        this.values = values;
    }

    public int getBinarySearch() {
        return binarySearch();
    }

    private int binarySearch(){

        int low = 0;
        int middle = 0; 
        int high = this.values.length-1;

        while(low <= high){
            middle = low + (high - low) / 2;
            if(this.key < values[middle]) high = middle - 1;
            else if(this.key > values[middle]) high = middle + 1;
            else return middle;
        }
        
        return -1;
    }

    
}
