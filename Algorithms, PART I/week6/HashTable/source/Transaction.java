public final class Transaction implements Comparable<Transaction>{

    private final String who;
    private final String when;
    private final String amount;

    public Transaction(String who, String when, String amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public boolean equals(Object y){
        return y.toString() == this.toString;
    }

    public int hashCode(){
        int hash = 17;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode();
        return hash;
    }
}
