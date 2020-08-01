package chapter1.creational.singleton;

/**
 * @Classname LazySingleton
 * @Description [单例模式]懒汉式
 * @Compiler CVBear
 * @Date 2020/7/20 15:40
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
        // 禁止反射(可选)
        /*if (instance != null) {
            throw new RuntimeException("禁止反射");
        }*/
    }

    /**
     * 获取实例
     * @return
     */
    /*public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }*/

    /**
     * 获取实例[改进1] synchronized
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
