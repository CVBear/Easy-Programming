package prototype;

/**
 * @Classname ValueTest
 * @Description 值传递测试
 * @Compiler CVBear
 * @Date 2020/7/23 12:00
 */
public class ValueTest {

    public static void main(String[] args) {
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" +percent);
    }

    public static void tripleValue(double x) // doesn't work
    {
        x = 3 * x;
    }

}
