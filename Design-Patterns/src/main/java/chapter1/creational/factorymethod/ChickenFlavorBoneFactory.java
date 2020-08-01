package chapter1.creational.factorymethod;

/**
 * @Classname ChickenFlavorBoneFactory
 * @Description 鸡肉味骨头工厂类
 * @Compiler CVBear
 * @Date 2020/7/20 11:20
 */
public class ChickenFlavorBoneFactory implements BoneFactory {
    @Override
    public Bone create() {
        return new ChickenFlavorBone();
    }
}
