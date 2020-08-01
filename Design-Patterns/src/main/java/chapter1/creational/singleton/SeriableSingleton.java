package chapter1.creational.singleton;

import java.io.Serializable;

/**
 * @Classname SeriableSingleton
 * @Description [单例模式]饿汉式序列化
 * @Date 2020/7/20 16:25
 */
public class SeriableSingleton implements Serializable{

    private static final SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {

    }

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
