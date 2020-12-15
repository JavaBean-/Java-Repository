package xu.barry.stu.jcth.utils.model;

public class Father {

    private String name;

    private int age;

    public Father(String name, int i) {
        this.name = name;
        this.age = i;
    }

    public Father() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
