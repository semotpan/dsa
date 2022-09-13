package dsa.strings;

/**
 * deterministic finite-state automaton - dfa
 */
public final class DFA {

    private final String pat;
    private final int[][] dfa;

    // Build DFA from pattern.
    public DFA(String pat) {
        this.pat = pat;

        var M = pat.length();
        var R = 256;
//        var R = 26; // {A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z} (char - 'A')
//        var R = 26; // {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z} (char - 'a')   charAt(pat, 0, 'A')
//        var R = 57 // {A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,[,\,],^,_,`,
//                   //     a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z} (char - 'A')

        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++) {
            // Compute DFA
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];     // Copy mismatch cases.
            }
            dfa[pat.charAt(j)][j] = j + 1; // Set match case.
            X = dfa[pat.charAt(j)][X];     // Update restart state.
        }
    }

    public int search(String text) {

        // Simulate operation of DFA on txt.
        var N = text.length();
        var M = pat.length();
        int i = 0, j = 0;

        for (; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }

        if (j == M) {
            return i - M; // found (hit end of pattern)
        }

        return -1; // not found
    }
}
