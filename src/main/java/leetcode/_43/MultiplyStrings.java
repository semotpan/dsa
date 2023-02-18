package leetcode._43;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        var nc1 = num1.toCharArray();
        var nc2 = num2.toCharArray();
        var ans = new int[nc1.length + nc2.length];

        for (var i = nc1.length - 1; i >= 0; i--) {
            var c = nc1[i] - '0';
            for (var j = nc2.length - 1; j >= 0; j--)
                ans[i + j + 1] += c * (nc2[j] - '0');
        }

        for (var i = ans.length - 1; i > 0; i--) {
            if (ans[i] > 9) {
                ans[i - 1] = ans[i - 1] + ans[i] / 10;
                ans[i] = ans[i] % 10;
            }
        }

        // remove leading 0
        int i = 0;
        while (ans[i] == 0) {
            i++;
        }

        var rez = new StringBuilder();
        while (ans.length > i) {
            rez.append((char) (ans[i++] + '0'));
        }

        return rez.toString();
    }

    public String multiply2(String num1, String num2) {
        int N1 = num1.length() - 1, N2 = num2.length() - 1;
        var rez = new int[N1 + N2 + 2];

        for (int i = N1, ii = 0; i >= 0; --i, ++ii) {
            int carry = 0, jj = 0, n1 = num1.charAt(i) - '0';

            for (int j = N2; j >= 0; j--, ++jj) {
                var n2 = num2.charAt(j) - '0';
                var sum = n1 * n2 + rez[ii + jj] + carry;
                carry = sum / 10;
                rez[ii + jj] = sum % 10;
            }

            if (carry > 0)
                rez[ii + jj] += carry;
        }

        // ignore '0's from the right
        int i = rez.length - 1;
        while (i >= 0 && rez[i] == 0)
            i--;

        if (i == -1)
            return "0";

        var answer = new StringBuilder();
        while (i >= 0) answer.append(rez[i--]);

        return answer.toString();
    }
}
