import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Topological;

public class AcyclicSP {
    
    private DirectedEdge[] edgeToEdge;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s){

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for(int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        Topological topological = new Topological(G);
        for(int v: topological.order())
            for(DirectedEdge e : G.adj(v))
                relax(e);
    }
}
