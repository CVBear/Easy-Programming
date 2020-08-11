package recursion.solution_0104;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Classname Solution3
 * @Description 104.二叉树的最大深度
 * @Algorithm Iteration[迭代] BFS 队列辅助
 * @Url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        // 0.特判
        if (root == null) {
            return 0;
        }

        // 1.辅助数据结构
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        // 2.用于统计层数
        int depth = 0;

        while (!queue.isEmpty()) {
            // 此层节点数
            int size = queue.size();

            // 迭代此层节点
            while (size-- > 0) {
                TreeNode curNode = queue.poll();

                // 添加下层节
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                // 添加下层节
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            depth++;
        }

        return depth;

    }
}
