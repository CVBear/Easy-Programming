package abstractfactory;

import chapter1.creational.abstractfactory.Bone;
import chapter1.creational.abstractfactory.Fruit;
import chapter1.creational.abstractfactory.SuperMarketFactory;
import chapter1.creational.abstractfactory.VanguardFactory;
import chapter1.creational.abstractfactory.WalMartFactory;
import org.junit.Test;

/**
 * @Classname Client
 * @Description [抽象工厂模式]客户端(测试类)
 * @Compiler CVBear
 * @Date 2020/7/20 12:15
 */
public class Client {

    @Test
    public void test() {
        // 工厂1
        SuperMarketFactory vanguard = new VanguardFactory();
        Bone chickenBone = vanguard.sellBone();
        chickenBone.eat();

        Fruit banana = vanguard.sellFruit();
        banana.eat();

        // 工厂2
        SuperMarketFactory walmart = new WalMartFactory();
        Bone beefBone = walmart.sellBone();
        beefBone.eat();

        Fruit apple = walmart.sellFruit();
        apple.eat();
    }

}
