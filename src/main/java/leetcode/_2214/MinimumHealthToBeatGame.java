package leetcode._2214;

public class MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        var maxDamage = 0L;
        var total = 0L;
        for (int value : damage) {
            total += value;
            maxDamage = Long.max(maxDamage, value);
        }

        return total - Long.min(maxDamage, armor) + 1;
    }
}
