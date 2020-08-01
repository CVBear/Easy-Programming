package simplefactory;

import chapter1.creational.simplefactory.BeefFlavorBone;
import chapter1.creational.simplefactory.Bone;
import chapter1.creational.simplefactory.BoneFactory;
import org.junit.Test;

/**
 * @Classname Clent
 * @Description [简单工厂模式]客户端(测试类),此模式不属于GOF23种设计模式，但它是学习其他工厂模式的基础
 * @Compiler CVBear
 * @Date 2020/7/20 10:37
 */
public class Client {

    /**
     * 1.简单工厂第一版
     */
    @Test
    public void test1() {
        BoneFactory boneFactory = new BoneFactory();
        Bone beefBone = boneFactory.create("BeefFlavor");
        beefBone.addFlavor();
    }

    /**
     * 2.[优化客户端调用]利用static
     */
    @Test
    public void test2() {
        Bone beefBone = BoneFactory.create("BeefFlavor");
        beefBone.addFlavor();
    }

    /**
     * 3.[开闭原则思想]不改变create方法中(内部)的判断，可以支持外部的变化
     */
    @Test
    public void test3() {
        Bone beefBone = BoneFactory.create(BeefFlavorBone.class);
        beefBone.addFlavor();
    }
}
