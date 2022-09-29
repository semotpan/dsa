package leetcode._2116;

public class CheckIfAParenthesesStringCanBeValid {

    public boolean canBeValid(String s, String locked) {

        if ((s.length() & 1) == 1)
            return false;

        var lckd = 0;
        var balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    balance++;
                    lckd++;
                } else {
                    balance--;
                    lckd--;
                }
            } else {
                balance++;
                lckd--;
            }

            if (balance < 0)
                return false;

            if (lckd < 0)
                lckd = 0;
        }

        return lckd == 0;
    }
}
