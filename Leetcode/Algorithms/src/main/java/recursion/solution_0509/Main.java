package recursion.solution_0509;

/**
 * @Classname Main
 * @Description 递归与迭代最基本的认识
 * @Compiler CVBear
 * @Date 2020/8/19 23:19
 */
public class Main {

    public static void main(String[] args) {
        iteration();
        iterationX(100);
        System.out.println(recursion(0, 1));
        System.out.println(recursionX(100, 1));
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    private static void iteration() {
        int sum = 0;

        // 迭代
        for (int i = 1; i <= 100; i++) {
            // 迭代体
            sum += i;
        }

        System.out.println(sum);
    }

    /**
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     */
    private static void iterationX(int n) {
        // 迭代 Sn = na(1) + n(n-1)/2d
        // 递推关系
        int sum =  (1 + n) * n / 2;;
        System.out.println(sum);
    }


    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n) 函数栈开销
     */
    private static int recursion(int sum, int i) {
        // 1.[递归出口]：终止条件
        if (i > 100) {
            return sum;
        }

        // 递归体
        sum += i;

        // 尾递归
        return recursion(sum, i + 1);
    }

    private static int recursionX(int n, int i) {
        // 1.[递归出口]：终止条件
        if (i > 1) {
            return n;
        }

        // 递归体: 递推关系
        n =  (1 + n) * n / 2;;

        // 尾递归
        return recursionX(n, i + 1);
    }


}
