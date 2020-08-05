package recursion.solution_0119;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution2.java
 * @Description [递推]不考虑空间优化
 * @Algorithm Recursion
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    // 注意和118的区别,一个是第k行(i不用-1)一个是前k(i要-1)行
    public List<Integer> getRow(int rowIndex) {
        // 1.定义结果变量
        List<Integer> res = new ArrayList<>(rowIndex+1);

        // 2.调用递归函数
        return recursion(rowIndex, res);
    }

    // 递归
    private List<Integer> recursion(int rowIndex, List<Integer> res) {
        // 1.[递归出口]
        if (rowIndex == 0) {
            // base case
            res.add(1);
            return res;
        }

        // 2.[下潜]
        res = recursion(rowIndex-1, res);

        List<Integer> level = new ArrayList<>();

        // 因为只有一层所以不用[外循环]i
        // 4.[递推方程(循环不变式)]: f(i,j)=f(i−1,j)+f(i−1,j−1)
        level.add(1);
        for (int j = 1; j < rowIndex; j++) {
            level.add((res.get(j) + res.get(j-1)));
        }
        level.add(1);

        return level;

    }
}
