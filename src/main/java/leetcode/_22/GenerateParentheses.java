package leetcode._22;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    private final List<String> result = new LinkedList<>();
    private char [] current;

    public List<String> generateParenthesis(int N) {
        current = new char[N*2];
        generate(N, 0, 0, 0);
        return result;
    }

    private void generate(int N, int open, int close, int index) {
        if (open == N && close == N) {
            result.add(new String(current));
        }

        if (open < N) {
            current[index] = '(';
            generate(N, open + 1, close, index + 1);
        }
        if (close < open) {
            current[index] = ')';
            generate(N, open, close + 1, index + 1);
        }
    }
}
