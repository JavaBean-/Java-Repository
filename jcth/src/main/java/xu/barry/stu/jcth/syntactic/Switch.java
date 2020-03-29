package xu.barry.stu.jcth.syntactic;

/**
 * 支持
 * byte/Byte
 * short/Short
 * int/Integer
 * char/Character
 * String
 * 不支持
 * long/float/double
 *
 * JDK12 多分支选择语句
 *  int result = 0;
 *  switch(month){
 *      case "jan" -> result = 31;
 *      case "Apr" -> result = 30;
 *      default  -> result = -1;
 *  }
 *
 *  int num = 1;
 *  int days = switch(num){
 *      case 1,3,5,7,8,10,12 -> 31;
 *      case 4,6,9,11 -> result = 30;
 *      default  -> {
 *          int result = 28;
 *          break result;//代码块中break返回结果
 *      }
 *  }
 */
public class Switch {
}
