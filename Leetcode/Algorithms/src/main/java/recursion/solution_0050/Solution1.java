package recursion.solution_0050;

/**
 * @Classname Solution1
 * @Description 50.Pow(x, n)
 * @Algorithm Iteration[迭代] 快速幂
 * @Url https://leetcode-cn.com/problems/powx-n/
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution1 {

    //二进制中的1相乘,下面提到的[贡献]就是2进制中的1
    public double myPow(double x, int n) {
        // 将n为负数的情况转换为1/x的n次幂
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;

        // 贡献的初始值为 x
        double x_contribute = x;

        // 迭代: 对n进行二进制拆分同时计入贡献
        for (long i = N;i > 0; i /= 2) {
            // 最低位为1则计入贡献, 奇数计入贡献,这一步就是把[贡献]累乘
            if ((i % 2) == 1) {
                ans = ans * x_contribute;
            }

            // 平方
            x_contribute = x_contribute * x_contribute;

            // 二进制右移,舍弃最低位,每次判断最低位
        }

        return ans;
    }
}
