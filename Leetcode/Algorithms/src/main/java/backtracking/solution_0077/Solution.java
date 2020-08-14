package backtracking.solution_0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution
 * @Description 77.组合
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/palindrome-partitioning/
 * @Compiler CVBear
 * @Date 2020/8/11 15:11
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 1.[定义结果]
        List<List<Integer>> res = new ArrayList<>();

        // 2.[特判]
        if (n <= 0 || k <= 0) {
            return res;
        }

        // 3.[月光宝盒]：申请栈
        LinkedList<Integer> path = new LinkedList<>();

        // 4.调用[回溯]函数
        backtrack(n, k, 1, path, res);

        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> path , List<List<Integer>> res) {
        // 1.[递归出口]：终止条件
        if (path.size() == k) {
            res.add(new LinkedList(path));
            return;
        }

        // 2.[迭代]
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            // [做选择]：拿得起
            path.addLast(i);

            // [回溯]
            backtrack(n, k, i+1, path, res);

            // [重新选择]：放得下
            path.removeLast();
        }

    }
}