package recursion.solution_0070;

/**
 * @Classname Solution2.java
 * @Description [递推]
 * @Algorithm Iteration
 * @Url https://leetcode-cn.com/problems/climbing-stairs/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution3 {
    public static int climbStairs(int n) {
        // 特判
        if (n <= 2) {
            return n;
        }

        // base case
        int f_2 = 1;
        int f_1 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            // [循环体]
            res = f_2 + f_1;
            f_2 = f_1;
            f_1 = res;
        }

        return res;
    }
}
