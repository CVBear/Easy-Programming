package prototype;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname ReferenceTest
 * @Description 引用传递?测试
 * @Compiler CVBear
 * @Date 2020/7/23 12:20
 */
@Slf4j(topic = "chapter1.ReferenceTest")
public class ReferenceTest {

    @Test
    public void test() {
        Employee harry = new Employee("Harry", 50000);
        log.info("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        log.info("After: salary=" + harry.getSalary());
    }

    public void tripleSalary(Employee x) {
        x.setSalary(200);
    }

}
