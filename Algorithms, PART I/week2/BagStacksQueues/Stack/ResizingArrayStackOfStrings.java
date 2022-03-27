public class ResizingArrayStackOfStrings {
    
    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }

    public vois push(String item){
        if(N == s.length) resize(2 * s.length);
        S[N++] = item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for(int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public String pop(){
        String item = s[--N];
        S[N] = null;
        if(N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }
}
