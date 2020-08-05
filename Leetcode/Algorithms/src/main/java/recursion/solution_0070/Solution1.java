package recursion.solution_0070;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description 记忆化搜索(自顶向下)
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/climbing-stairs/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public int climbStairs(int n) {
        return fib(n+1);// 一定要注意是爬n个台阶而不是第n个台阶因此要+1
    }

    public int fib(int N) {
        // 初始化[记忆表]填充-1
        int[] memo = new int[N+1];
        Arrays.fill(memo, -1);

        return helper(N, memo);
    }

    public int helper(int n, int[] memo) {
        // 1.[递归出口]
        if (n <= 1) {
            return n;
        }

        // 2.记忆化搜索
        if (memo[n] == -1) {
            memo[n] = helper(n-1,memo) + helper(n-2,memo);
        }

        return memo[n];
    }
}
