package recursion.solution_0119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution4
 * @Description [递归]空间优化 修改自Solution3
 * @Algorithm Rercursion
 * @Url [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)
 * @Compiler CVBear
 * @Date 2020/8/8 10:49
 */
public class Solution4 {

    public List<Integer> getRow(int rowIndex) {
        // 递推: 根据前一层推导后一层

        // 1.定义[返回值]
        List<Integer> cur = new ArrayList<>();

        return recursion(cur, rowIndex);
    }

    // 递归写法
    private List<Integer> recursion(List<Integer> cur, int rowIndex) {
        // 1.[递归出口] 和118不一样偶 是从0开始
        if (rowIndex == 0) {
            cur.add(1);
            return cur;
        }

        // 2.[下潜]：“梦境”下潜
        cur = recursion(cur, rowIndex-1);

        // 单独处理1层的情况
        if (rowIndex == 1) {
            cur.add(1);
            return cur;
        }

        // 前一层 left 也就是动态的j-1 cur.get(j-1)
        int j_1 = 1;

        // 3.[递归体]: 此层“梦境”的逻辑
        for (int j = 2-1; j < rowIndex; j++) {
            int next_j = cur.get(j);
            cur.set(j, j_1 + cur.get(j));//f(j) = i-1: f(j-1) + f(j)
            j_1 = next_j;
        }
        cur.add(1);

        return cur;
    }

}
