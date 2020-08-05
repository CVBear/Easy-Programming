package recursion.solution_0509;

/**
 * @Classname Solution1
 * @Description 尾递归: 不能避免函数栈溢出
 * @Algorithm Recursion
 * @Url
 * @Compiler CVBear
 * @Date 2020/8/5 9:13
 */
public class Solution2 {

    public static int fib(int N) {
        return recursion(N, 0, 1);
    }

    // [尾递归优化?]: 无需存储局部变量时可以使用尾递归优化
    public static int recursion(int n, int f_2, int f_1) {
        // base case
        if (n == 0) {
            return f_2;
        }

        // base case
        if (n == 1) {
            return f_1;
        }

        // [不变式]
        int res = f_1 + f_2;
        f_2 = f_1;
        f_1 = res;

        return recursion(n-1, f_2, f_1);
    }

    public static void main(String[] args) {
        int fib = fib(111000);
        System.out.println(fib);
    }
}
