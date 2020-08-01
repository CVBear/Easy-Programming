package chapter1.creational.prototype.deep;

/**
 * @Classname Skill
 * @Description 叮当的技能
 * @Compiler CVBear
 * @Date 2020/7/23 9:29
 */
public class Skill implements Cloneable {

    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * 添加克隆方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}