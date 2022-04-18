import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;

public class KruskalMST {
    
    private Queue<Edge> mst = new Queue<Edge>();

    public KruskalMST(EdgeWeightedGraph G) {

        MinPQ<Edge> pq = new MinPQ<Edge>();

        for(Edge e : G.getEdges())
            pq.insert(e);
        
        UF uf = new UF(G.V());
        while(!pq.isEmpty() && mst.size() < G.V() - 1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(!uf.connected(v, w)){
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }

    public Iterable<Edge> edges(){ return mst; }
}
