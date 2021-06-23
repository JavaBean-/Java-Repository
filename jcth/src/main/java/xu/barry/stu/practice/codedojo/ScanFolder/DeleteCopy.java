package xu.barry.stu.practice.codedojo.ScanFolder;

import xu.barry.stu.jcth.utils.Printer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteCopy {

      public static void main(String[] args) {

          long start = System.currentTimeMillis();
          List<String> paths = new ArrayList<String>();
          deleteCopyFile(new File("/Users/xuzhenlong/Desktop/test"));


      }


    private static List<String> deleteCopyFile(File filePath){
        File[] c = filePath.listFiles();
        Arrays.asList(c).forEach(f -> {
            if(f.getName().length() != "IMG_1218.jpeg".length()){
                f.delete();
            }else {
                System.out.println(f.getName());
            }
        });
        return null;
    }
 }

