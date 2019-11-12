package pers.learn.jdk.rmi;

public class Test {

    public static void main(String[] argv){

        Tree t =new Tree();
        Apple apple = (Apple) t;

    }

}

class Apple extends Tree{

}

class Tree{

}