package recursion.solution_0104;

/**
 * @Classname Solution1
 * @Description 104.二叉树的最大深度
 * @Algorithm Recursion[递归] DFS深度优先
 * @Url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return max(maxDepth(root.left), maxDepth(root.right)) + 1;// 从1开始
        }
    }

    private int max(int v, int w) {
        return v > w? v: w;
    }
}



