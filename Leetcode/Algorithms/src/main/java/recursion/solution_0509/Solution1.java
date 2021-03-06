package recursion.solution_0509;

/**
 * @Classname Solution1
 * @Description 509.斐波那契数
 * @Algorithm Recursion[普通递归] 傻递归
 * @Url https://leetcode-cn.com/problems/fibonacci-number/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {
    public static int fib(int N) {
        // 1.[递归出口]
        if (N <= 1) {
            return N;
        }

        return fib(N-1) + fib(N-2);
    }

    public static void main(String[] args) {
        fib(11100);
    }
}