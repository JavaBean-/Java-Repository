package pers.learn.jdk.rmi;
import java.rmi.Remote;

public interface IHello extends Remote {

    public String sayHello(String name) throws java.rmi.RemoteException;

}