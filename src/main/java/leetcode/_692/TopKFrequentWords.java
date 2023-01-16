package leetcode._692;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        var freq = new HashMap<String, Integer>();

        for (var word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>(
                (word1, word2) -> {
                    var diff = freq.get(word1) - freq.get(word2);
                    return diff == 0 ? word2.compareTo(word1) : diff;
                });

        for (var word : freq.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        LinkedList<String> answer = new LinkedList<>();
        while (!pq.isEmpty())
            answer.addFirst(pq.poll());

        return answer;
    }
}
