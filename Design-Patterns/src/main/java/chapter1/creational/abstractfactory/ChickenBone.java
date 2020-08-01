package chapter1.creational.abstractfactory;

/**
 * @Classname ChickenBone
 * @Description 鸡骨头
 * @Compiler CVBear
 * @Date 2020/7/20 13:51
 */
public class ChickenBone implements Bone {
    @Override
    public void eat() {
        System.out.println("吃鸡骨头");
    }
}
