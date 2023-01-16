package leetcode._394;

import java.util.ArrayDeque;

public class DecodeString {

    public String decodeString(String s) {
        var counterStack = new ArrayDeque<Integer>();
        var stringStack = new ArrayDeque<StringBuilder>();
        var answer = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counterStack.push(k);
                k = 0;
                stringStack.push(answer);
                answer = new StringBuilder();
            } else if (c == ']') {
                var decoded = stringStack.pop();
                for (int i = counterStack.pop(); i > 0; i--) {
                    decoded.append(answer);
                }
                answer = decoded;
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }

    public String decodeString2(String s) {
        var values = s.toCharArray();
        var stack = new ArrayDeque<Character>();

        for (var i = 0; i < values.length; ++i) {
            if (values[i] != ']') {
                stack.push(values[i]);
                continue;
            }

            var value = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                value.append(stack.pop());
            }

            stack.pop();

            int factor = 0, base = 1;
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                factor = factor + (stack.pop() - '0') * base;
                base *= 10;
            }

            value.reverse();

            var inner = new StringBuilder();
            while (factor > 0) {
                inner.append(value);
                --factor;
            }

            for (int k = 0; k < inner.length(); k++) {
                stack.push(inner.charAt(k));
            }
        }

        var answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
