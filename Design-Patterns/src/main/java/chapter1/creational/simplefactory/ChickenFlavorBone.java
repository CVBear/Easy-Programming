package chapter1.creational.simplefactory;

/**
 * @Classname ChickenFlavorBone
 * @Description 鸡肉味的骨头
 * @Compiler CVBear
 * @Date 2020/7/20 10:34
 */
public class ChickenFlavorBone implements Bone {
    @Override
    public void addFlavor() {
        System.out.println("添加了鸡肉香精");
    }
}
