package leetcode._93;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    private final List<String> ips = new ArrayList<>();

    public List<String> restoreIpAddresses(String digits) {
        back(digits, 0, 0, new StringBuilder());
        return ips;
    }

    private void back(String digits, int x, int dots, StringBuilder ip) {
        if (dots == 3) {
            var remainingDigitGroup = digits.substring(x);

            if (isValid(remainingDigitGroup))
                ips.add(ip.toString() + remainingDigitGroup);

            return;
        }

        for (int i = x + 1; i < digits.length(); ++i) {
            var digitGroup = digits.substring(x, i);

            if (isValid(digitGroup)) {
                ip.append(digitGroup).append('.');
                back(digits, i, dots + 1, ip);
                ip.delete(ip.length() - (i - x) - 1, ip.length());
            }
        }
    }

    private boolean isValid(String digitGroup) {
        var length = digitGroup.length();

        if (length == 0 || length > 3)
            return false;

        if (length > 1 && '0' == digitGroup.charAt(0))
            return false;

        return length < 3 || "255".compareTo(digitGroup) >= 0;
    }
}
