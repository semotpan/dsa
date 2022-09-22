package leetcode._13;

import java.util.Stack;

public class RomanToInteger {

    public int romanToInt(String s) {
        var sum = 0;
        var chars = s.toCharArray();
        var stack = new Stack<Integer>();

        for (var i = 0; i < chars.length; i++) {
            stack.push(valueOf(chars[i]));

            while ((i + 1) < chars.length && stack.peek() < valueOf(chars[i + 1])) {
                stack.push(valueOf(chars[++i]));
            }

            var curr = stack.pop();
            while (!stack.isEmpty()) {
                curr -= stack.pop();
            }

            sum += curr;
        }

        return sum;
    }

    private int valueOf(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
