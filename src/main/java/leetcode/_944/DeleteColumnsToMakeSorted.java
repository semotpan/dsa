package leetcode._944;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        var deletedColumns = 0;

        for (var col = 0; col < strs[0].length(); ++col) {
            for (var row = 1; row < strs.length; ++row) {
                if (strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    ++deletedColumns;
                    break;
                }
            }
        }

        return deletedColumns;
    }
}
