package backtracking.solution_0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution
 * @Description 47.全排列 II
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 * @Compiler CVBear
 * @Date 2020/8/12 09:20
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 1. 定义返回值
        List<List<Integer>> res = new ArrayList<>();

        // 2.特判
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 3.排序
        Arrays.sort(nums);

        // 4.调用回溯
        // 申请[月光宝盒]
        LinkedList<Integer> path = new LinkedList<>();
        int[] visited = new int[nums.length];

        backtrack(nums, path, res, visited);

        return res;
    }

    

    private void backtrack(int[] nums,LinkedList<Integer> path, List<List<Integer>> res,  int[] visited) {
        // 1.[递归出口]: 终止条件
        if (path.size() == nums.length) {
            res.add(new LinkedList(path));
            return;
        }

        // 2.[递归体]: 
        for (int i = 0; i < nums.length; i++) {
            // 本次dfs去重
            if (visited[i] == 1) {
                continue;
            }

            // 大剪枝 小剪枝
            if (i > 0 && nums[i] == nums[i-1]  && visited[i-1] != 1) {
                continue;
            }

            // 做选择: 拿得起
            path.addLast(nums[i]);

            // 标记法：已使用
            visited[i] = 1;

            // [下潜]
            backtrack(nums, path, res, visited);

            // 状态清理, 只用于一次[下潜]
            visited[i] = 0;
            
            // 重新选择：放得下
            path.removeLast();
        }

    }
}