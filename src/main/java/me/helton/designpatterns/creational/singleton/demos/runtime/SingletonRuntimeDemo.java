package me.helton.designpatterns.creational.singleton.demos.runtime;

public class SingletonRuntimeDemo {
    public static void main(String[] args) {
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc();
        System.out.println(singletonRuntime);

        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance);

        if (singletonRuntime == anotherInstance) {
            System.out.println("They're the same instance!");
        }
    }
}
