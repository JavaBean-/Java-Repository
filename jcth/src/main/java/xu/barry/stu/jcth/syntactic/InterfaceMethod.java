package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

/**
 *  Java最初设计接口都没有方法实现
 *  Java8推出接口的默认方法/静态方法（都带实现）
 *  为lambda表达式提供支持
 *
 *  1：默认方法不能重写Object中的方法
 *  2：实现类可以继承/重写，父接口的默认方法
 *  3：接口可以继承/重写父接口的默认方法
 *  4：当都父接口和父类都有相同方法签名的默认方法，
 *     子类继承父类的默认方法（兼容JDK7之前的代码）
 *  5：子类实现了2个接口均还有相同方法签名的默认方法，编译失败
 */
public class InterfaceMethod {

    @Test
    public void test(){

    }
}
interface Animal{
    void move();
}
interface NewAnimal{
    default void move(){
        System.out.println("NewAnimal");
    }
}

abstract class  NewFlyAnimal implements NewAnimal{
  public void move(){
      System.out.println("NewFlyAnimal");
   };
}

interface NewLandAnimal extends NewAnimal{
    default void move(){
        System.out.println("NewLandAnimal");
    }
}
