public class LSD {
    
    public static void main(String[] args) {
        
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];

        for(int d = W-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for(int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for(int r = 0; r < N; r++)
                count[r+1] += count[r];
            for(int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for(int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}
