package chapter1.creational.abstractfactory;

/**
 * @Classname ChickenBone
 * @Description 牛骨头
 * @Compiler CVBear
 * @Date 2020/7/20 13:51
 */
public class BeefBone implements Bone {
    @Override
    public void eat() {
        System.out.println("吃牛骨头");
    }
}
