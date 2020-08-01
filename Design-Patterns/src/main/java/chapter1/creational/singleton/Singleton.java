package chapter1.creational.singleton;


import java.io.Serializable;

/**
 * @Classname Singleton
 * @Description [枚举]单例模式
 * @Compiler CVBear
 * @Date 2020/7/22 19:17
 */
public enum Singleton implements Serializable {

    INSTANCE;

    // 可要可不要
    public void method() {
        System.out.println("可以写你想要的逻辑代码");
    }

}
