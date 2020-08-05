package recursion.solution_0509;

/**
 * @Classname Solution
 * @Description 傻递归
 * @Algorithm Recursion
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {
    public int fib(int N) {
        // 1.[递归出口]
        if (N <= 1) {
            return N;
        }
        // 2.[尾递归]
        return fib(N-1) + fib(N-2);
    }
}
