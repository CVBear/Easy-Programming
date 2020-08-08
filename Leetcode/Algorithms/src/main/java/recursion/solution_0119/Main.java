package recursion.solution_0119;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;

/**
 * @Classname Main
 * @Description 测试对象头
 * @Compiler CVBear
 * @Date 2020/8/7 17:50
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("本机虚拟机详情：");
        System.out.println(VM.current().details());

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("对象内存布局：");
        System.out.print(ClassLayout.parseInstance(list).toPrintable());
    }

}
