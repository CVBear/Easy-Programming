package chapter1.creational.singleton;

/**
 * @Classname InnerClassLazySingleton
 * @Description [单例模式]懒汉式静态内部版
 * @Compiler CVBear
 * @Date 2020/7/20 17:17
 */
public class InnerClassLazySingleton {

    private InnerClassLazySingleton() {
    }

    public static InnerClassLazySingleton getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final InnerClassLazySingleton INSTANCE = new InnerClassLazySingleton();
    }

    public static void main(String[] args) {
        InnerClassLazySingleton instance = InnerClassLazySingleton.getInstance();
    }
}
