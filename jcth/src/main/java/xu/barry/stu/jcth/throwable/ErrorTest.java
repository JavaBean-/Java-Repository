package xu.barry.stu.jcth.throwable;

/**
 * -Xms32m -Xmx32m
 */
public class ErrorTest {

    public static void main(String[] argv){
        ErrorTest et = new ErrorTest();
        try {
            et.outOfMemoryError();
        }catch (Throwable t){
            System.out.println(t.getCause());
        }finally {
            System.out.println("Jump out outOfMemoryError!");
        }

        try {
            et.stackOverflowError();
        }catch (Throwable t){
            System.out.println(t.getCause());
        }finally {
            System.out.println("Jump out stackOverflowError!");
        }
    }

    private void outOfMemoryError(){
        byte[] bytes = new byte[1024 * 1024 * 30];
    }

    private void stackOverflowError(){
        this.stackOverflowError();
    }

}
