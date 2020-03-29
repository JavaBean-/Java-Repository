package xu.barry.stu.jcth.syntactic;


import xu.barry.stu.jcth.utils.model.Father;
import xu.barry.stu.jcth.utils.model.Son;

/**
 * 局部类型推断
 * 优点：
 *  避免信息冗余
 *  对齐变量名
 *  跟容易阅读
 *  本质还是强类型语言，编译器推断类型，只在编译阶段，跟JVM无关
 *  并写入字节码文件
 * 限制：
 *  用在局部变量，非类成员变量
 *  可以再for/for-each循环中
 *  声明是必须初始化
 *  不能用在方法（形式）参数，返回类型
 *  大面积使用，导致代码整体阅读性变差
 */
public class VarType {

    public void varType(){

        var a = 0;
        var b = 1;
        var c = "string";
        //var b2;//Cannot infer type: 'var' on variable without initializer

        //三目运算，var动态推算b3类型
        var b3 = b > a ? c : a ;

        var d = new Father();
        var e = new Son();
        d = e;//支持向上转型
        //e = d;//Required type:Son     Provided:Father
    }

    /**
     *  Cannot resolve symbol 'var'
     */
//    var method(var paramter){
//        return null;
//    }

}
