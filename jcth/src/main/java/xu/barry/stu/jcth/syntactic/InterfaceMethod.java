package xu.barry.stu.jcth.syntactic;

/**
 * Java最初设计接口都没有方法实现
 * Java8推出接口的默认方法/静态方法（都带实现）
 * 为lambda表达式提供支持
 * <p>
 * 1：默认方法不能重写Object中的方法
 * 2：实现类可以继承/重写，父接口的默认方法
 * 3：接口可以继承/重写父接口的默认方法
 * 4：当都父接口和父类都有相同方法签名的默认方法，
 * 子类继承父类的默认方法（兼容JDK7之前的代码）
 * 5：子类实现了2个接口均还有相同方法签名的默认方法，编译失败
 * </p>
 * 接口方法优先调用关系：
 * 1，类优先于接口。 如果一个子类继承的父类和接口有相同的方法实现。 那么子类继承父类的方法
 * 2，子类型中的方法优先于父类型中的方法
 * 3，如果以上条件都不满足， 则必须显示覆盖/实现其方法，或者声明成abstract
 */

interface A {
    default void hello() {
        System.out.println("hello from A");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("hello from B");
    }
}

class C implements A {

}

interface D {
    default void hello() {
        System.out.println("hello from D");
    }
}

class X implements A, B {

    X(){
        super();

    }
    X(int i){
        this();
    }

    public static void main(String[] args) {
        /**
         * 比较A，B接口中move方法
         * 由于B是A的子类，选择调用B类move方法（就近，更具体）
         */
        new X().hello();//hello from B
    }
}

class Y extends C implements A, B {
    public static void main(String[] args) {
        /**
         * 优先调用C中move方法
         * 由于C为重写move方法
         * 转而比较A，B接口中move方法
         * 由于B是A的子类，选择调用B类move方法（就近，更具体）
         */
        new Y().hello();//hello from B
    }
}

class Z implements A, B, D {
    /**
     * 不重写的话报错
     * Z inherits unrelated defaults for hello()
     * from A and D
     */
    @Override
    public void hello() {
        //编译错误，冗余方法，move方法已经被B接口重写
        //A.super.hello();
        /**
         *  调用D中move方法
         */
        D.super.hello();
        System.out.println("hello from Z");
    }

    public static void main(String[] args) {
        new Z().hello();//hello from D      hello from Z
    }
}