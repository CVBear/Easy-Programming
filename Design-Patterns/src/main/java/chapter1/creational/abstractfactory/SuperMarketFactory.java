package chapter1.creational.abstractfactory;

/**
 * @Classname SuperMarket
 * @Description [抽象工厂]超市工厂类
 * @Compiler CVBear
 * @Date 2020/7/20 13:39
 */
public interface SuperMarketFactory {
    Bone sellBone();
    Fruit sellFruit();
}
