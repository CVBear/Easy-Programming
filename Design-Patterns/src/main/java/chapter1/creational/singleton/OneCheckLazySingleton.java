package chapter1.creational.singleton;

/**
 * @Classname OneCheckLazySingleton
 * @Description [单例模式]懒汉式 单校验版
 * @Compiler CVBear
 * @Date 2020/7/20 15:40
 */
public class OneCheckLazySingleton{

    private static OneCheckLazySingleton instance;

    private OneCheckLazySingleton() {
    }

    /**
     * 获取实例[改进2] OneCheck
     * @return
     */
    public static OneCheckLazySingleton getInstance() {
        if (instance == null) {// check1 这个只是为了减少synchronized提高效率
            synchronized (OneCheckLazySingleton.class) {
                /* 模拟抖动会更明显
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                instance = new OneCheckLazySingleton();
            }
        }
        return instance;
    }
}
