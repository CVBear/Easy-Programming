package backtracking.solution_0046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution
 * @Description 46.全排列
 * @Algorithm backtracking[回溯]
 * @Url https://leetcode-cn.com/problems/permutations/
 * @Compiler CVBear
 * @Date 2020/8/11 15:11
 */
class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 1.定义结果
        List<List<Integer>> res = new ArrayList(len);

        if (nums == null || len == 0) {
            return res;
        }

        // 2.[月光宝盒]
        // Deque<Integer> path = new ArrayDeque();
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(nums, path, res);
        return res;
    }

    // [回溯]
    private static void backtrack(int[] nums, LinkedList<Integer> path, List<List<Integer>> res) {
        // 1.[递归出口]: 当路径走到了尽头
        if (path.size() == nums.length) {
            res.add(new LinkedList(path));
            return;
        }

        // 2.在[此层梦境]迭代
        for (int i = 0; i < nums.length; i++) {
            // [减枝]
            if (path.contains(nums[i])) {
                continue;
            }
            // [做选择]: 拿得起
            path.addLast(nums[i]);
            // [下潜]
            backtrack(nums, path, res);
            // [重新选择]: 放得下
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            for (Integer num : list) {
                System.out.print(num);
            }
            System.out.println("");
        }
    }
}