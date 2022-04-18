public class DirectedEdge {
    
    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight){

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int form(){
        return v;
    }

    public int to(){
        return w;
    }

    public int weight(){
        return weight;
    }
}
