package singleton;

import chapter1.creational.singleton.DoubleCheckLazySingleton;
import chapter1.creational.singleton.HungrySingleton;
import chapter1.creational.singleton.InnerClassLazySingleton;
import chapter1.creational.singleton.LazySingleton;
import chapter1.creational.singleton.OneCheckLazySingleton;
import chapter1.creational.singleton.SeriableSingleton;
import chapter1.creational.singleton.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Classname Client
 * @Description [单利模式]客户端(测试类)
 * @Compiler CVBear
 * @Date 2020/7/20 15:47
 */
@Slf4j(topic = "chapter1.Client")
public class Client {

    /**
     * [饿汉式]测试: 并发情况下获取是否为单例
     */
    @Test
    public void testHungry() {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                HungrySingleton instance = HungrySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }

    /**
     * [懒汉式]改进1测试: 并发情况下获取是否为单例
     */
    @Test
    public void testLazy() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                LazySingleton instance = LazySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }

    /**
     * [懒汉式]改进2测试: 并发情况下获取是否为单例
     */
    @Test
    public void testOneCheck() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                OneCheckLazySingleton instance = OneCheckLazySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }

    /**
     * [懒汉式]改进2测试: 并发情况下获取是否为单例
     */
    @Test
    public void testDoubleCheck() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }

    /**
     * [懒汉式]测试: 并发情况下获取是否为单例
     */
    @Test
    public void testInnerLazy() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                InnerClassLazySingleton instance = InnerClassLazySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }

    /**
     * [懒汉式]测试: 反射破坏单例测试
     * 解决方式: 构造方法空判
     */
    @Test
    public void testReflection() {
        try {
            Class objectClass = Singleton.class;
            Constructor c = objectClass.getDeclaredConstructor();
            c.setAccessible(true);

            Singleton o1 = Singleton.INSTANCE;
            Singleton o2 = (Singleton) c.newInstance();

            log.info((o1 == o2) + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * [饿汉式]测试: 并发情况下获取是否为单例
     */
    @Test
    public void testInnerClassHolder() {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                InnerClassLazySingleton instance = InnerClassLazySingleton.getInstance();
                log.info("实例地址：" + instance.hashCode());
            }, "线程" + i).start();
        }
    }


    /**
     * [枚举]单例测试
     */
    @Test
    public void testEnumSingleton() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                log.info("实例地址：" + Singleton.INSTANCE.hashCode());
            }, "线程" + i).start();
        }
    }


    /**
     * 测试: 序列化破坏单例
     */
    @Test
    public void testSeriable() {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            //序列化：输出到根路径文件Seriable
            fos = new FileOutputStream("Seriable");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            //反序列化：从Seriable文件读取到内存
            FileInputStream fis = new FileInputStream("Seriable");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton)ois.readObject();
            ois.close();

            log.info((s1 == s2 )+ "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
