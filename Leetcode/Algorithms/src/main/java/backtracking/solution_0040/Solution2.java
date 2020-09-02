package backtracking.solution_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Classname Solution
 * @Description 40.组合总和 II 只取第一个
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/combination-sum-ii/
 * https://www.it610.com/article/97267.htm
 * @Compiler CVBear
 * @Date 2020/8/14 15:00
 */
class Solution2 {
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
        // 只取第一个
        /*if (res.size() != 0) {
            return;
        }*/

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

    // 测试
    public static void main(String[] args) {
        int[] nums = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            nums[i] = rand.nextInt(100) + rand.nextInt(100) + 50;
        }

        List<Integer> math = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            math.add(rand.nextInt(100) + rand.nextInt(100) + 50);
        }

        for (Integer target : math) {
            List<List<Integer>> list = combinationSum2(nums, target);

            if (list != null && list.size() != 0) {
                int sum = 0;
                for (Integer num : list.get(0)) {
                    sum += num;
                }

                System.out.println(target + " " +sum);
            }

        }
    }

}