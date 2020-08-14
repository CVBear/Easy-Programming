package backtracking.solution_0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Solution2
 * @Description 39.组合总和
 * @Algorithm backtracking[回溯] 便于"剪枝"
 * @Url https://leetcode-cn.com/problems/combination-sum/
 * @Compiler CVBear
 * @Date 2020/8/14 09:24
 */
class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1.[定义返回值]
        List<List<Integer>> res = new ArrayList();

        // 2.特判
        if (candidates == null || candidates.length == 0) {
            return res;
        }   

        // 前置[剪枝]条件,辅助下面的剪枝,但在工作中我不推荐
        Arrays.sort(candidates);

        // 3.[月光宝盒]
        LinkedList<Integer> path = new LinkedList<>();
       
        // 4.[回溯函数]
        backtrack(candidates, res, path, target, 0);

        // 5.返回
        return res;
    }

    /**
     *
     * @param candidates 选择项
     * @param res 返回值
     * @param path 路径(就是答案)
     * @param target 这个代表的是剩余值 target-candidates[i] = 目标值-当前选择项 = 剩余值，回溯以后又是原target了
     * @param start 起始起点, 因为[1,2]和[2,1]属于排列但是在组合里只能存在一个
     */
    private void backtrack(int[] candidates, List<List<Integer>> res, LinkedList<Integer> path, int target, int start) {
        // 1.[递归出口]：终止条件
        if (target == 0) {
            res.add(new LinkedList(path));
            return;
        }
            

        // 2.[迭代]
        for (int i = start; i < candidates.length; i++) {
            // [约束法]：通过约束"剪枝"
            if (target - candidates[i] < 0) {
                // 有了前置的排序因此直接break因为已经超出了后续也没有可能性了
                break;
            }

            // 补充缺陷(option)：使用在工作中的情况 [2,2,3] target = 5
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // [做选择]：拿得起
            path.addLast(candidates[i]);

            // [回溯]
            backtrack(candidates, res, path, target-candidates[i], i);
            
            // [重新选择]：放得下
            path.removeLast();
        }

    }
}