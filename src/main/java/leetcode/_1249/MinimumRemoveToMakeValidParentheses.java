package leetcode._1249;

import java.util.ArrayDeque;
import java.util.HashSet;

public class MinimumRemoveToMakeValidParentheses {
    // using stack and cache
    public String minRemoveToMakeValid(String s) {
        var stack = new ArrayDeque<Integer>();
        var skipIndex = new HashSet<Integer>();

        for (var i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> stack.push(i);
                case ')' -> {
                    if (stack.isEmpty()) {
                        skipIndex.add(i);
                        continue;
                    }
                    // remove valid from stack
                    stack.pop();
                }
            }
        }
        // copy invalid indexes to set
        while (!stack.isEmpty()) {
            skipIndex.add(stack.pop());
        }

        // build string
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!skipIndex.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
