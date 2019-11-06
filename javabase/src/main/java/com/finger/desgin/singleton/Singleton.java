package com.finger.desgin.singleton;

public class Singleton {

    /** 私有构造方法，防止被实例化 */
    private Singleton(){
    }

    /** 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    /** volatile 保证读的过程，写必须完成 -解决 03 带来的问题*/
    private static volatile Singleton singleton=null;

    /** 01 静态工程方法，创建实例 */
    public static Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    /** 02 线程安全方式*/
    public static synchronized Singleton getSynInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    /** 03 只有在第一次创建对象的时候需要加锁，之后就不需要了，所以，这个地方需要改进-线程安全方式*/
    /** 如果在多线程情况下， A,B 两个线程同时访问，
     * A 执行完成 new Singleton,但是还没有 return ,
     * 此时B 过来发现singleton 非空，但是由于 A 线程并未完成 return，那么B 就有可能获取到未实例化完成的对象*/
    /** 可以通过加 volatile 关键字来解决*/
    public static Singleton getSynOptInstance(){
        if(singleton==null){
            synchronized(singleton){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    /** 04 继续优化
     * 内部类方式- JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
     * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
     * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题
     */
    private static class SingletonFatory{
        private static Singleton singleton=new Singleton();

        public static Singleton getInstance(){
            return singleton;
        }
    }
    /** 04 调用内部类*/
    public static Singleton getInsideInstace(){
        return SingletonFatory.getInstance();
    }

    /** 05 枚举模式*/
    private static enum SingletonEnum{
        INSTANCE;

        private Singleton singleton=null;

        SingletonEnum(){
            singleton = new Singleton();
        }

        public Singleton getInstance(){
            return singleton;
        }
    }
    /** 05 调用枚举模式*/
    public static Singleton getEnumInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    /** 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve(){
        return singleton;
    }
}
