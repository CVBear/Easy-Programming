package recursion.solution_0119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution3
 * @Description [倒推]空间优化 不推荐
 * @Algorithm Iteration
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        // 递推: 根据前一层推导后一层

        // 1.定义[返回值]
        List<Integer> cur = new ArrayList<>(rowIndex+1);//避免出现复杂度震荡
        //List<Integer> cur = new ArrayList<>(); //存在

        // 简单情况 base case
        cur.add(1);

        // 前一层 left 也就是动态的j-1 cur.get(j-1)
        int pre = 1;

        // 迭代
        for (int i = 1; i <= rowIndex ; i++) {
            for (int j = 1; j < i; j++) {
                int temp = cur.get(j);
                cur.set(j, pre + cur.get(j));
                pre = temp;
            }
            // right base case
            cur.add(1);
        }

        return cur;
    }
}
