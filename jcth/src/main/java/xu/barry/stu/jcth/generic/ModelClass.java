package xu.barry.stu.jcth.generic;

public class ModelClass {
}


class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}
class GreenApple extends Apple{}

class A {}
class B extends A {}
class C extends B {}

/**
 * JDK1.5版本以后
 * 方法重写返回值，可以协变
 * 子类重写方法的返回值可以是父类方法的返回值的子类
 */
class Son extends Father {
    public C f(B obj) {
        return new C();
    }
}

class Father {
    public B f(B obj) {
        return new B();
    }
}