package backtracking.solution_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution
 * @Description 40.组合总和 II
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/combination-sum-ii/
 * @Compiler CVBear
 * @Date 2020/8/14 15:00
 */
class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 1.[定义返回值]
        List<List<Integer>> res = new ArrayList<>();

        // 特判
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        // 2.[前置准备]
        Arrays.sort(candidates);

        // 3.[月光宝盒]
        LinkedList<Integer> path = new LinkedList<>();

        // 4.[回溯函数]
        backtrack(candidates, path, res, target, 0);

        // 5.[返回]
        return res;
    }

    private static void backtrack(int[] candidates, LinkedList<Integer> path, List<List<Integer>> res, int target, int start) {
        // 1.[递归出口]
        if (target == 0) {
            res.add(new LinkedList(path));
            return;
        }

        // 2.[迭代]
        for (int i = start; i < candidates.length; i++) {
            // [大剪枝]: i > start才是对的,避免在同一条路径"误剪"
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // [小剪枝]: 约束法
            if (target - candidates[i] < 0) {
                break;
            }

            // [做选择]：拿得起
            path.addLast(candidates[i]);

            // [回溯]
            backtrack(candidates, path, res, target - candidates[i], i + 1);

            // [重新选择]：放得下
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 1, 5};
        List<List<Integer>> list = combinationSum2(nums, 8);
        System.out.println(list);
    }

}