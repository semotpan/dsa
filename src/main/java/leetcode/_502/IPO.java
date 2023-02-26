package leetcode._502;

import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // based on w select k projects with highest profit?
        var pjs = new PriorityQueue<PC>((pca, pcb) -> pca.capital() - pcb.capital() == 0 ? pcb.profit() - pca.profit() : pca.capital() - pcb.capital());
        for (int i = 0; i < profits.length; ++i)
            pjs.add(new PC(capital[i], profits[i]));

        // System.out.println(pjs);

        var maxProfits = new PriorityQueue<Integer>((a, b) -> b - a);

        while (k > 0) {
            while (!pjs.isEmpty() && pjs.peek().capital() <= w)
                maxProfits.add(pjs.poll().profit());

            if (maxProfits.isEmpty()) break;

            w += maxProfits.poll();
            --k;
        }


        return w;
    }
}

record PC(int capital, int profit) {}
