package recursion.solution_0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution1
 * @Description 递归(自顶向下)
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/pascals-triangle/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        // 0.定义结果变量
        List<List<Integer>> res = new ArrayList<>();

        // 1.[特判]
        if (numRows == 0) {
            return res;
        }

        // 2.调用辅助函数
        return recursion(numRows, res);
    }

    //递归函数
    private List<List<Integer>> recursion(int numRows, List<List<Integer>> res) {
        // 1.[递归出口]
        if(numRows == 1) {
            res.add(Arrays.asList(1));
            return res;
        }

        // 2.[下潜]
        res = recursion(numRows-1,res);
        // [递归体]

        // 3.定义[此层集合]
        List<Integer> level = new ArrayList<>();
        // 添加左[base case]
        level.add(1);

        // 4.[递推方程(循环不变式)]: f(i,j)=f(i−1,j)+f(i−1,j−1)
        int i = numRows-1;// i代表第几行从0开始,这个是为了保证和循环的[递推方程]一直保证你能够找到不变的规律
        for (int j = 1; j < i; j++) {// numRows-1是因为最后右边也属于base case
            level.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));// -2是因为数组是从0开始的
        }

        // 添加右[base case]
        level.add(1);

        // 5.添加[此层集合]
        res.add(level);

        return res;
    }
}
