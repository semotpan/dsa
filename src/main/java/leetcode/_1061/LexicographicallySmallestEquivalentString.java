package leetcode._1061;

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        var uf = new UnionFind(26);

        for (int i = 0; i < s1.length(); ++i) {
            uf.union(s1.charAt(i), s2.charAt(i));
        }

        var answer = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            answer.append(uf.findEquivalence(baseStr.charAt(i)));
        }

        return answer.toString();
    }
}

class UnionFind {

    private final int[] id;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(char p, char q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        if (pID < qID) {
            id[qID] = pID;
        } else {
            id[pID] = qID;
        }
    }

    private int find(int p) {
        p = p - 'a';
        while (p != id[p])
            p = id[p];
        return p;
    }

    public char findEquivalence(char p) {
        return (char) (find(p) + 'a');
    }
}
