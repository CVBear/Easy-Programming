package chapter1.creational.prototype.shallow1;

/**
 * @Classname Skill
 * @Description 具体原型类: 叮当的技能
 * @Compiler CVBear
 * @Date 2020/7/23 9:29
 */
public class Skill implements Prototype {

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

    @Override
    public Skill clone() {
        Skill skill = new Skill();
        skill.setName(this.name);
        return skill;
    }
}