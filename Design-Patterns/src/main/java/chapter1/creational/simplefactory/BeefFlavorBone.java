package chapter1.creational.simplefactory;

/**
 * @Classname BeefFlavorBone
 * @Description 牛肉味的骨头
 * @Compiler CVBear
 * @Date 2020/7/20 10:36
 */
public class BeefFlavorBone implements Bone {
    @Override
    public void addFlavor() {
        System.out.println("添加了牛肉香精");
    }
}
