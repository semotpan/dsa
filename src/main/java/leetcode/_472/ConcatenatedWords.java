package leetcode._472;

import java.util.*;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        var answer = new ArrayList<String>();
        var min = Integer.MAX_VALUE;

        var set = new HashSet<String>(words.length, 1.0F);
        for (var word : words) {
            if (word.length() > 0)
                set.add(word);

            min = Integer.min(min, word.length());
        }

        for (String word : words) {
            if (word.length() < min * 2) continue;

            if (isConcatenated(set, word, 0, word.length(), min))
                answer.add(word);
        }

        return answer;
    }

    private boolean isConcatenated(Set<String> set, String word, int start, int end, int min) {
        for (int i = start + min; i <= end - min; i++) {
            if (set.contains(word.substring(start, i)) && (set.contains(word.substring(i, end)) || isConcatenated(set, word, i, end, min))) {
                return true;
            }
        }
        return false;
    }
}

class TrieSolution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        var trie = new Trie();
        var minSize = Integer.MAX_VALUE;

        for (String word : words) {
            minSize = Integer.min(minSize, word.length());
            trie.add(word);
        }

        var rez = new ArrayList<String>();


        for (String word : words) {
            if (word.length() < minSize * 2) continue;

            var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
            pq.offer(0);

            while (!pq.isEmpty()) {
                var start = pq.poll();

                if (start == word.length()) {
                    rez.add(word);
                    break;
                }

                pq.addAll(trie.search(word, start, Integer.min(word.length(), word.length() - minSize + start)));
            }
        }

        return rez;
    }
}

class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void add(String word) {
        var node = root;
        for (var ch : word.toCharArray()) {
            node.put(ch);
            node = node.get(ch);
        }
        node.end = true;
    }

    public List<Integer> search(String word, int start, int end) {
        var q = new ArrayList<Integer>();
        var node = root;
        for (int i = start; i < end; ++i) {
            if (!node.containsKey(word.charAt(i))) break;

            node = node.get(word.charAt(i));

            if (node.end) q.add(i + 1);
        }
        return q;

    }

    private static class Node {

        private final Node[] links;
        private boolean end;

        public Node() {
            this.links = new Node[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch) {
            if (containsKey(ch)) return;
            links[ch - 'a'] = new Node();
        }
    }
}

