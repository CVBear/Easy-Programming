package chapter1.creational.prototype.deep;

/**
 * @Classname DingDang
 * @Description 叮当[浅克隆]
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
        DingDang shadow = (DingDang)super.clone();
        Skill skill = (Skill)shadow.getSkill().clone();
        shadow.setSkill(skill);
        return shadow;
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

    public static void main(String[] args) throws CloneNotSupportedException {
        DingDang dingDang = new DingDang();
        DingDang shadow = (DingDang)dingDang.clone();
        System.out.println("Before skill: " + dingDang.getSkill() + ", sex: " + dingDang.getSex());
        // [叮当]和[分身]是同一个对象吗
        System.out.println("Object Reference: " + (dingDang == shadow));// false
        System.out.println("Reference Type: " + (dingDang.getSkill() == shadow.getSkill()));// true
        // [影子分身]拥有了新技能: 咬人
        shadow.getSkill().setName("咬人");
        // [影子分身]拥有了新性别: 雌性
        shadow.setSex(1);
        // [叮当]的技能变了吗? [叮当]性别变了吗？
        System.out.println("End skill: " + dingDang.getSkill() + ", sex: " + dingDang.getSex());
    }
}
