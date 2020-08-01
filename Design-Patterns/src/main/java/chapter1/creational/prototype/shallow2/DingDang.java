package chapter1.creational.prototype.shallow2;

/**
 * @Classname DingDang
 * @Description 叮当[浅克隆]
 * Cloneable 属于标的接口 只有一个方法
 * @Compiler CVBear
 * @Date 2020/7/23 9:29
 */
public class DingDang implements Cloneable {
    /*叮当的经*/
    private Skill skill = new Skill("装死");
    /*叮当1岁*/
    private int age = 1;
    /*有4颗最锋利的牙齿*/
    private int sharpTooth = 4;
    /*没有尾巴*/
    private boolean tail = false;
    /*公的*/
    private int sex = 0;
    //... 叮当有着很多属性呢

    /**
     * 浅拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public DingDang clone() throws CloneNotSupportedException {
        return (DingDang) super.clone();
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSharpTooth() {
        return sharpTooth;
    }

    public void setSharpTooth(int sharpTooth) {
        this.sharpTooth = sharpTooth;
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
