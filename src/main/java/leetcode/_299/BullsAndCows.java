package leetcode._299;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        var freqSecret = new int[10];
        var freqGuess = new int[10];

        var bulls = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            freqSecret[secret.charAt(i) - '0']++;
            freqGuess[guess.charAt(i) - '0']++;
        }

        var total = 0;
        for (int i = 0; i < 10; ++i) {
            total += Integer.min(freqGuess[i], freqSecret[i]);
        }

        return new StringBuilder()
                .append(bulls).append('A')
                .append((total - bulls)).append('B').toString();
    }
}
