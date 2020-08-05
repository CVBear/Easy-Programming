package recursion.solution_0050;

/**
 * @Classname Solution2.java
 * @Description [递归]快速幂
 * @Algorithm Recursion
 * @Url https://leetcode-cn.com/problems/powx-n/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {

    public double myPow(double x, int n) {
        // 将n为负数的情况转换为1/x的n次幂
        long N = n;// 防溢出
        if (n < 0) {
            x = 1 / x;
            N = -N;// 这里会溢出
        }

        return quickPow(x, N);
    }

    private double quickPow(double x, long n) {
        // [递归出口]
        if (n == 0) {
            return 1.0;
        }

        double half = quickPow(x, n/2);

        //[递归体]

        if (n % 2 == 0) {// 奇数则中间相乘
            return half * half;
        } else {// 奇数需要再乘一个x
            return half * half * x;
        }
    }
}
