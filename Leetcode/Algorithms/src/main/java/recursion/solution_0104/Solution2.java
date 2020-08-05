package recursion.solution_0104;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname Solution2
 * @Description 迭代[栈辅助]
 * @Algorithm Iteration
 * @Url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    // 前序遍历的思想
    public int maxDepth(TreeNode root) {
        // 1.[辅助结构]
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();

        // 2.初始化
        if (root != null) {
            stack.push(new Pair(root, 1));
        }

        // 3.深度
        int depth = 0;

        // 4.迭代
        while (!stack.isEmpty()) {
            // 此层映射
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            // 当前深度
            int current_depth = current.getValue();

            if (root != null) {
                // 更新深度
                depth = Math.max(depth, current_depth);
                stack.push(new Pair(root.left, current_depth + 1));
                stack.push(new Pair(root.right, current_depth + 1));
            }
        }
        // [返回]
        return depth;
    }
}
