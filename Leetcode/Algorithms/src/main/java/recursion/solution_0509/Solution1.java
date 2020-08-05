package recursion.solution_0509;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description
 * @Algorithm Recursion
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public int fib(int N) {
        // 初始化[记忆表]填充-1(-1即为未记忆)
        int[] memo = new int[N+1];
        Arrays.fill(memo, -1);

        return recursion(N, memo);
    }

    public int recursion(int n, int[] memo) {
        // 1.[递归出口]
        if (n <= 1) {
            return n;
        }

        // 2.[记忆化搜索]
        // 未记忆
        if (memo[n] == -1) {
            memo[n] = recursion(n-1,memo) + recursion(n-2,memo);
        }

        // 记忆了
        return memo[n];
    }
}
