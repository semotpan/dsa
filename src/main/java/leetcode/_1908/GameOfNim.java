package leetcode._1908;

public class GameOfNim {

    public boolean nimGame(int[] piles) {
        var nim = 0;
        for (var p : piles)
            nim ^= p;

        return nim != 0;
    }
}
