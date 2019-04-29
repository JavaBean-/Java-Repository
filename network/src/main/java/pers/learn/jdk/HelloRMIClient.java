package pers.learn.jdk;

import java.rmi.Naming;

public class HelloRMIClient {
    public static void main(String[] args) {
        try {
            IHello lookup = (IHello) Naming.lookup("rmi://100.98.62.170:1099/hello");

            int i = 0;
            while(true){
                Thread.sleep(100);
                System.out.println(lookup.sayHello("barry"+(i++)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}