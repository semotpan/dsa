package leetcode._1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/single-threaded-cpu/">1834. Single-Threaded CPU</a>
 * <p>
 * <p>
 * You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where
 * tasks[i] = [enqueueTime(i), processingTime(i)] means that the i-th task will be available to process
 * at enqueueTime(i) and will take processingTime(i) to finish processing.
 * <p>
 * You have a single-threaded CPU that can process at most one task at a time and will act in the
 * following way:
 * <p>
 * - If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 * - If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
 * If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 * - Once a task is started, the CPU will process the entire task without stopping.
 * - The CPU can finish a task then start a new one instantly.
 * <p>
 * Return the order in which the CPU will process the tasks.
 */
public class SingleThreadedCPU {

    // Time Exceeded
    public int[] getOrderTE(int[][] tasks) {

        var waiting = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));
        var order = new int[tasks.length];
        int[] active = null;

        for (int timer = tasks[0][0], i = 0, index = 0; (i < tasks.length || !waiting.isEmpty()); timer++) {
            while (i < tasks.length && tasks[i][0] == timer) {
                waiting.add(new int[]{tasks[i][0], tasks[i][1], i++});
            }

            if (!waiting.isEmpty() && (active == null || active[1] < timer)) {
                active = waiting.poll();
                order[index++] = active[2];
            }
        }

        return order;
    }

    public int[] getOrder(int[][] tasks) {

        var sorted = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }

        Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));

        var order = new int[tasks.length];
        var waitingQueue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1] == 0 ? o1[2] - o2[2] : o1[1] - o2[1]);

        for (int i = 0, currentTime = 0, index = 0; i < sorted.length || !waitingQueue.isEmpty();) {

            if (waitingQueue.isEmpty() && currentTime < sorted[i][0]) {
                currentTime = sorted[i][0];
            }

            while (i < sorted.length && currentTime >= sorted[i][0]) {
                waitingQueue.add(sorted[i]);
                i++;
            }

            var active = waitingQueue.poll();
            var processingTime = active[1];
            var taskIndex = active[2];

            currentTime += processingTime;
            order[index++] = taskIndex;
        }


        return order;
    }
}
