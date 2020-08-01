package prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname ReferenceTest
 * @Description 引用传递?测试
 * @Compiler CVBear
 * @Date 2020/7/23 12:20
 */
@Slf4j(topic = "chapter1.SwapReferenceTest")
public class SwapReferenceTest {

    public static void main(String[] args) {
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
       log.info("Before: a=" + a.getName());
       log.info("Before: b=" + b.getName());
        swap(a, b);
       log.info("After: a=" + a.getName());
       log.info("After: a=" + a.getSalary());
       log.info("After: b=" + b.getName());
       log.info("After: b=" + b.getSalary());
    }

    public static void swap(Employee x, Employee y)
    {
        Employee temp = x;
        x = y;
        y = temp;
    }

}
