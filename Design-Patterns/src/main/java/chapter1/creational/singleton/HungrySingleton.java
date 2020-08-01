package chapter1.creational.singleton;

/**
 * @Classname HungrySingleton
 * @Description [单例模式]饿汉式
 * @Date 2020/7/20 16:25
 */
public /*final*/ class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
