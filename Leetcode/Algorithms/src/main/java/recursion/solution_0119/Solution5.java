package recursion.solution_0119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution5
 * @Description [倒推]空间优化 推荐最优解
 * @Algorithm Iteration
 * @Url [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution5 {
    public List<Integer> getRow(int rowIndex) {
        // 递推: 根据前一层推导后一层

        // 1.定义[返回值]
        List<Integer> res = new ArrayList<>();
        // 简单情况 base case
        res.add(1);

        // 前一层 pre level
        int j_1 = 1;
        int[] cur = new int[rowIndex+1];
        for (int i = 1; i <= rowIndex ; i++) {
            for (int j = 1; j < i; j++) {
                int temp = cur[j];
                cur[j] = j_1 + cur[j];
                j_1 = temp;
            }
            // right base case
            cur[i] = 1;
        }

        for (int i = 1; i <= rowIndex; i++) {
            res.add(cur[i]);
        }

        return res;
    }
}
