package factorymethod;

import chapter1.creational.factorymethod.BeefFlavorBoneFactory;
import chapter1.creational.factorymethod.Bone;
import chapter1.creational.factorymethod.ChickenFlavorBoneFactory;
import org.junit.Test;

/**
 * @Classname Client
 * @Description [工厂方法模式]客户端(测试类)
 * @Compiler CVBear
 * @Date 2020/7/20 11:25
 */
public class Client {

    @Test
    public void test() {
        // 1.创建牛肉味骨头
        BeefFlavorBoneFactory bfbFactory = new BeefFlavorBoneFactory();
        Bone beefFlavorBone = bfbFactory.create();
        beefFlavorBone.addFlavor();

        // 2.创建鸡肉味骨头
        ChickenFlavorBoneFactory cfbFactory = new ChickenFlavorBoneFactory();
        Bone chickenFlavorBone = cfbFactory.create();
        chickenFlavorBone.addFlavor();
    }
}
