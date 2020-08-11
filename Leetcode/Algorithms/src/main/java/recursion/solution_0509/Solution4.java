package recursion.solution_0509;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description 509.斐波那契数
 * @Algorithm Iteration[迭代] 递推
 * @Url https://leetcode-cn.com/problems/fibonacci-number/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution4 {

    public static int fib(int N) {
        // 1.特判
        if (N <= 1) {
            return N;
        }

        // base case,相当于双指针中的pre和cur
        int f_2 = 0, f_1 = 1;

        // 3.递推
        int res = 0;
        for (int i = 2; i <= N; i++) {
            // [循环体]
            res = f_1 + f_2;
            f_2 = f_1;
            f_1 = res;
        }

        return res;
    }

    public static void main(String[] args) {
        fib(111000);
    }
}
