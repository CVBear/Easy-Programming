package recursion.solution_0070;

/**
 * @Classname Solution2.java
 * @Description [尾递归]
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/climbing-stairs/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    public static int climbStairs(int n) {
        // 特判
        if (n <= 2) {
            return n;
        }

        // 调用递归,相当于从n=3开始的
        return recursion(n,1,2);
    }

    private static int recursion(int n, int f_2, int f_1) {
        // 1.[递归出口]
        if (n <= 2) {
            return f_1;// f_1是最后的res
        }

        // 2.[尾递归]
        return recursion(n-1, f_1, f_2+f_1);
    }
}
