package recursion.solution_0119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution2.java
 * @Description 119.杨辉三角 II
 * @Algorithm Iteration[迭代] 不考虑空间优化
 * @Url https://leetcode-cn.com/problems/pascals-triangle-ii
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        // 1.定义结果变量
        List<List<Integer>> res = new ArrayList<>();
        // base case
        res.add(Arrays.asList(1));

        // 2.特判
        if (rowIndex == 0) {
            return res.get(0);
        }

        // 3.循环
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> level = new ArrayList<>();

            // 因为只有一层所以不用[外循环]i
            // 4.[递推方程(循环不变式)]: f(i,j)=f(i−1,j)+f(i−1,j−1)
            level.add(1);
            for (int j = 1; j < i; j++) {
                level.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            level.add(1);
            res.add(level);
        }

        return res.get(rowIndex);
    }
}
