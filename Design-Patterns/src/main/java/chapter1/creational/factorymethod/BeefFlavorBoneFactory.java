package chapter1.creational.factorymethod;

/**
 * @Description 牛肉味骨头工厂类
 * @Compiler CVBear
 * @Date 2020/7/20 11:20
 */
public class BeefFlavorBoneFactory implements BoneFactory {
    @Override
    public Bone create() {
        return new BeefFlavorBone();
    }
}
