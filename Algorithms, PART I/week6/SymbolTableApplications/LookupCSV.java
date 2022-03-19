import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LookupCSV {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyfield = Integer.parseInt(args[1]);
        int valfield = Integer.parseInt(args[2]);

        ST<String, String> st = new ST<String, String>();
        while(!in.isEmpty()){
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyfield];
            String val = tokens[valfield];
            st.put(key, val);
        }

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(!st.contains(s)) StdOut.println("Not Found");
            else StdOut.println(st.get(s)); 
        }
    }
}
