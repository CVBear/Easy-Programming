package recursion.solution_0119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution4
 * @Description [倒推]空间优化 推荐
 * @Algorithm Iteration
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution4 {
    public List<Integer> getRow(int rowIndex) {
        // 递推: 根据前一层推导后一层

        // 1.定义[返回值]
        List<Integer> res = new ArrayList<>();
        // 简单情况 base case
        res.add(1);

        // 前一层 pre level
        int pre = 1;
        int[] cur = new int[rowIndex+1];
        for (int i = 1; i <= rowIndex ; i++) {
            for (int j = 1; j < i; j++) {
                int temp = cur[j];
                cur[j] = pre + cur[j];
                pre = temp;
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
