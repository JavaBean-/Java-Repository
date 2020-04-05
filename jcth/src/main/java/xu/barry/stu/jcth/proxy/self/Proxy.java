package xu.barry.stu.jcth.proxy.self;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Proxy {

    public static Object newProxyInstance(Class interf, InvocationHandler h) throws ClassNotFoundException, NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String rt = "\r\t";

        String strMethod = "";

        for (Method m : interf.getDeclaredMethods()) {
            strMethod += "@Override" + rt
                    + "public " + m.getReturnType() + " " + m.getName() + "(){" + rt
                    + "try{" + rt
                    + "Method md = " + interf.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt
                    + "h.invoke(this,md);" + rt
                    + "}catch(Exception e){" + rt
                    + "e.printStackTrace();" + rt
                    + "}" + rt
                    + "}";
        }
        String strClass = "package xu.barry.stu.jcth.proxy.self;" + rt
                + "import xu.barry.stu.jcth.proxy.self.InvocationHandler;" + rt
                + "import java.lang.reflect.Method;" + rt
                + "public class $proxy0 implements " + interf.getName() + "{" + rt
                + "private InvocationHandler h;" + rt
                + "public $proxy0(InvocationHandler h){" + rt
                + "super();" + rt
                + "this.h = h; }" + rt
                + strMethod + rt
                + "}";

        Constructor ctr = generateFileAndLoadclass(strClass);

        return ctr.newInstance(h);

    }

    private static Constructor generateFileAndLoadclass(String classStr)
            throws IOException, ClassNotFoundException, NoSuchMethodException {
        /**
         * windows 系统虚拟机获得路径
         * /D:/Documents/GitHub/Java-Repository/jcth/target/classes/
         */
        String path = Proxy.class.getResource("/").getPath();
        /**
         * /D:/Documents/GitHub/Java-Repository/jcth/target/classes/xu/barry/stu/jcth/proxy/self/
         */
        String path1 = Proxy.class.getResource("").getPath();

        if (isWindows()) {
            path1 = path1.substring(1);
        }

        String filename = path1 + "$proxy0.java";

        File file = new File(filename);

        FileUtils.writeStringToFile(file, classStr);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);

        fileMgr.getJavaFileObjects(filename);
        // 获取文件
        Iterable unit = fileMgr.getJavaFileObjects(filename);
        // 编译任务
        CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, unit);
        // 进行编译
        Boolean call = t.call();

        fileMgr.close();
        // 类加载器
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        Class c = cl.loadClass("xu.barry.stu.jcth.proxy.self.$proxy0");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            return true;
        }
        return false;
    }
}
