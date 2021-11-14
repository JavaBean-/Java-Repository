package xu.barry.stu.practice.codedojo.ScanFolder;

import xu.barry.stu.jcth.utils.Printer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScanFolder {

      public static void main(String[] args) {

          long start = System.currentTimeMillis();
          List<String> paths = new ArrayList<String>();
          paths = getAllFilePaths(new File("D:\\jenkins\\opensearch"), paths);

          long end = System.currentTimeMillis();
          Printer.partition(paths.size() + " "+ (end - start));
      }
             private static List<String> getAllFilePaths(File filePath,List<String> filePaths){
                     File[] files = filePath.listFiles();
                     if(files == null){
                             return filePaths;
                         }
                     for(File f:files){
                             if(f.isDirectory()){
                                     getAllFilePaths(f,filePaths);
                                 }else{
                                 if(f.getPath().endsWith("java")){
                                     filePaths.add(f.getPath());
                                 }
                                 }
                         }
                     return filePaths;
                 }
 }

