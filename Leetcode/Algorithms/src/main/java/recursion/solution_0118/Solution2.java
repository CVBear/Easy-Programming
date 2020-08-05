package recursion.solution_0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution2.java
 * @Description 迭代(自底向上)
 * @Algorithm Iteration
 * @Url https://leetcode-cn.com/problems/pascals-triangle/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        // 0.定义结果变量
        List<List<Integer>> res = new ArrayList<>();

        // 1.[特判]
        if (numRows == 0) {
            return res;
        }

        // 2.base case,初始化了第一行1,这里简化了new ArrayList的步骤但是你要知道放在了res.get(0)的位置
        // 初始化这一层的目的是为了保证后面的base case均在左右两边
        res.add(Arrays.asList(1));

        // 3.[循环]：使用递推方程
        for (int i = 1; i < numRows; i++) {
            // [循环体]

            // 4.[此层数组]
            ArrayList<Integer> level = new ArrayList<>();

            // 左base case
            level.add(1);

            //[递推方程(循环不变式)]: f(i,j)=f(i−1,j)+f(i−1,j−1)
            for (int j = 1; j < i; j++) {
                // [递推方程]
                level.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }

            // 右base case
            level.add(1);
            res.add(level);
        }

        return res;
    }
}
