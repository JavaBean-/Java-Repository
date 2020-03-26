package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * try-with-resource
 * 资源对象必须实现AutoCloseable,及实现close方法
 */
public class TryResource {

    @Test
    public void read(){
        try(Stream<String> input = Files.lines(Paths.get("C:\\Users\\ezxuxzh\\Documents\\New Text Document.txt"))){
            input.forEach(System.out::println);
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }

    @Test
    public void resource(){
        try(Resource r = new Resource()){
            r.getSomething();
            System.out.println("Get resource!");
        }catch (IOException e){
            System.out.println(e.toString());
        }
        System.out.println("Get resource ending!");
    }
}
class Resource implements AutoCloseable{

    public Resource() throws IOException {
        throw new IOException();
    }

    void getSomething(){
        System.out.println("Get Something!");
    }

    @Override
    public void close(){
        System.out.println("Close!");
    }
}