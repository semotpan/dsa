package leetcode._1071;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String s1, String s2) {
        if (s2.length() > s1.length()) return gcdOfStrings(s2, s1);

        if (!s1.startsWith(s2)) return "";

        if (s2.length() == s1.length()) return s2;

        return gcdOfStrings(s1.substring(s2.length()), s2);
    }


    public String gcdOfStrings2(String s1, String s2) {
        if (s2.length() > s1.length())
            return gcdOfStrings2(s2, s1);

        while (s1.startsWith(s2)) {
            if (s2.length() == s1.length()) return s2;

            s1 = s1.substring(s2.length());

            if (s1.length() < s2.length()) {
                var temp = s1;
                s1 = s2;
                s2 = temp;
            }
        }

        return "";
    }
}
