package chapter1.creational.simplefactory;

/**
 * @Classname BoneFactory
 * @Description 骨头工厂类
 * [简单工厂模式] 不属于 GOF23种设计模式却是你理解别的工厂模式的基础
 * @Compiler CVBear
 * @Date 2020/7/20 10:37
 */
public class BoneFactory {

    /**
     * 创建骨头
     * 这种创建方式违反了[开闭原则]
     * 当叮当要别的口味的骨头还得修改代码
     *
     * @param type
     * @return
     */
    public static Bone create(String type) {
        switch (type) {
            case "BeefFlavor":
                return new BeefFlavorBone();
            case "ChickenFlavor":
                return new ChickenFlavorBone();
            default:
                throw new IllegalArgumentException("argument to create() is null");
        }
    }

    /**
     * 创建骨头
     * 弥补上面代码的不足
     *
     * @param clazz
     * @return
     */
    public static Bone create(Class<? extends Bone> clazz) {
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("argument to create() is invalid");
    }

}
