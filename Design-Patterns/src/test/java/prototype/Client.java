package prototype;


import chapter1.creational.prototype.shallow1.DingDang;
import chapter1.creational.prototype.shallow1.Prototype;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Classname Client
 * @Description 测试类
 * @Compiler CVBear
 * @Date 2020/7/23 17:21
 */
@Slf4j(topic = "chapter1.Client")
public class Client {

    @Test
    public void test() {
        DingDang dingDang = new DingDang();
        DingDang shadow = (DingDang)copy(dingDang);
        log.info("Before skill: " + dingDang.getSkill() + ", sex: " + dingDang.getSex());
        // [叮当]和[分身]是同一个对象吗
        log.info("Object Reference: " + (dingDang == shadow));// false
        log.info("Reference Type: " + (dingDang.getSkill() == shadow.getSkill()));// true
        // [影子分身]拥有了新技能: 咬人
        shadow.getSkill().setName("咬人");
        // [影子分身]拥有了新性别: 雌性
        shadow.setSex(1);
        // [叮当]的技能变了吗? [叮当]性别变了吗？
        log.info("End skill: " + dingDang.getSkill() + ", sex: " + dingDang.getSex());
    }

    public static Prototype copy(Prototype concretePrototype){
        return (Prototype)concretePrototype.clone();
    }

}
