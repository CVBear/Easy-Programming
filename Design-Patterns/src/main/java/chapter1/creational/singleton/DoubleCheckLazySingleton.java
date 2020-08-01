package chapter1.creational.singleton;

/**
 * @Classname DoubleCheckLazySingleton
 * @Description [单例模式]懒汉式 双重校验版
 * @Compiler CVBear
 * @Date 2020/7/20 15:40
 */
public class DoubleCheckLazySingleton {

    private static /*volatile*/ DoubleCheckLazySingleton instance;

    private static int number = 0;

    private DoubleCheckLazySingleton() {
    }

    /**
     * 获取实例[改进2] DoubleCheck
     * @return
     */
    public static DoubleCheckLazySingleton getInstance() {
        if (instance == null) {// check1 这个只是为了减少synchronized提高效率
            synchronized (DoubleCheckLazySingleton.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (instance == null) {// check2 防止多个实例
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }

    public static int getNumber() {
        return number;
    }
}
