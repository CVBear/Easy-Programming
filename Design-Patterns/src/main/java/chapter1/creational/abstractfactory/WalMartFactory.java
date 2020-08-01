package chapter1.creational.abstractfactory;

/**
 * @Classname WalMart
 * @Description [具体工厂]沃尔玛超市
 * @Compiler CVBear
 * @Date 2020/7/20 13:54
 */
public class WalMartFactory implements SuperMarketFactory {
    @Override
    public Bone sellBone() {
        return new BeefBone();
    }

    @Override
    public Fruit sellFruit() {
        return new Apple();
    }
}
