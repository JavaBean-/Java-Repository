package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import static java.lang.Integer.MAX_VALUE;
//Field 'MAX_VALUE' is already defined in a single static import
//import static java.lang.Double.MAX_VALUE;

/**
 * 到入一个类的静态方法和变量
 * 少使用通配符，最好具体到静态变量或方法
 * 静态方法应具有明确特征，如有重名，需要不全类名
 */
public class ImportStatic {

    @Test
    public void importMath(){
        int a = 3 , b= 4;
        double c = sqrt(pow(a,2)+pow(b,2));
        out.println(c);
        out.println(MAX_VALUE);
        out.println(java.lang.Double.MAX_VALUE);
    }
}
