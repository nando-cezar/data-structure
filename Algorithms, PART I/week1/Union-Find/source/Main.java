import java.util.Random;

public class Main {

    public static void main(String[] args){

        WeightedQuickUnionUF quickUnion = new WeightedQuickUnionUF(10);
        Random numberRandom = new Random();
        int numberI = 0;
        int numberJ = 0;

        for(int i = 0; i < 10; i++) {
            numberI = numberRandom.nextInt(10);
            numberJ = numberRandom.nextInt(10);
            quickUnion.union(numberI, numberJ);
            System.out.println(quickUnion.connected(numberI, numberJ));
            System.out.println(numberI + " | " + numberJ);
        }
    }  
}
