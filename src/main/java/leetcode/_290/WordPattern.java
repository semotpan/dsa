package leetcode._290;

import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        var letters = pattern.toCharArray();
        var words = s.split(" ");

        if (letters.length != words.length) {
            return false;
        }


        var hash = new String[26];
        var dictionary = new HashSet<>();

        for (int i = 0; i < letters.length; i++) {

            var index = letters[i] - 'a';
            if (hash[index] == null) {
                if (dictionary.contains(words[i])) {
                    return false;
                }

                hash[index] = words[i];
                dictionary.add(words[i]);
                continue;
            }

            if (!hash[index].equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}