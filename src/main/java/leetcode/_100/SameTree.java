package leetcode._100;

import leetcode.TreeNode;

import java.util.Objects;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) || Objects.isNull(q))
            return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
