package recursion.solution_0509.tailRecursion;

/**
 * @Classname Main
 * @Description lambda避免尾递归溢出网上的说法,待研究
 * @Compiler CVBear
 * @Date 2020/8/5 16:43
 */
public class Main {

    /**
     * 阶乘计算 -- 使用尾递归接口完成
     * @param factorial 当前递归栈的结果值
     * @param number 下一个递归需要计算的值
     * @return 尾递归接口,调用invoke启动及早求值获得结果
     */
    public static TailRecursion<Integer> factorialTailRecursion(final int factorial, final int number) {
        if (number == 1)
            return TailInvoke.done(factorial);
        else
            return TailInvoke.call(() -> factorialTailRecursion(factorial + number, number - 1));
    }

    /**
     * 阶乘计算 -- 尾递归解决
     *
     * @param factorial 上一轮递归保存的值
     * @param number    当前阶乘需要计算的数值
     * @return number!
     */
    public static int factorialTailRecursion2(final int factorial, final int number) {
        if (number == 1) return factorial;
        else return factorialTailRecursion2(factorial * number, number - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorialTailRecursion(1,1000000000).invoke());
//        System.out.println(factorialTailRecursion2(1,1000000000));
    }

}
