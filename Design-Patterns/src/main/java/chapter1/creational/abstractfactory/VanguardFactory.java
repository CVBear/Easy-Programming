package chapter1.creational.abstractfactory;

/**
 * @Classname Vanguard
 * @Description [具体工厂]华润万家(超市)
 * @Compiler CVBear
 * @Date 2020/7/20 13:50
 */
public class VanguardFactory implements SuperMarketFactory {
    @Override
    public Bone sellBone() {
        return new ChickenBone();
    }

    @Override
    public Fruit sellFruit() {
        return new Banana();
    }
}
