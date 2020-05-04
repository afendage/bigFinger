#并发编程实战
---
##什么是线程安全性
---
* 无状态对象（无实例变量的对象，无存储数据能力）:就是对于一次操作，不能保存数据。无状态对象(Stateless Bean)是没有实例变量的对象，
不能保存数据，是不变类，是线程安全的。例如:
```java
public class A {  
   public A() {}  
   public String hello() {  
      return "Hello 谁？";  
   }  
}  
  
public class Client {  
   public Client() {  
      A a = new A();  
      System.out.println(a.hello());  
      A b = new A();  
      System.out.println(b.hello());  
   }  
}
```

* 有状态对象（有实例变量的对象，有存储数据能力）：也称为有状态对象(Stateful Bean)，就是有实例变量的对象，
可以保存数据，是非线程安全的。在不同方法调用间不保留任何状态.例如:
```java
public class B {  
      private String name;  
      public B(String arg) {  
      this.name = arg;  
      }  
      public String hello() {  
         return "Hello" + this.name;  
      }  
   }  
  
public class Client {  
  public Client() {  
     B a = new B("中国");  
     System.out.println(a.hello());  
     B b = new B("世界");  
     System.out.println(b.hello());  
  }  
}
```

* 大多数Servlet都是无状态的，从而极大地降低了在实现Servlet线程安全性时的复杂性。
只有当Servlet在处理请求时需要保存一些信息，线程安全性才会成为一个问题。

### 注解辅助标识
---
* @ThreadSafe 是表示这个类是线程安全的。具体是否真安全，那要看实现者怎么实现的了，反正打上这个标签只是表示一下。不线程安全的类打上这个注解也没事儿。
* @Immutable 表示，类是不可变的，包含了　@ThreadSafe　的意思。
* @NotThreadSafe 表示这个类不是线程安全的。如果是线程安全的非要打上这个注解，那也不会报错。
* 如果我们需要使用它们，需要导入额外的依赖项：jcip-annotations.jar。

##原子性
---
* 竞态条件（Race Condition）：计算的正确性取决于多个线程的交替执行时序时，就会发生竞态条件。列：
```java
@NotThreadSafe
public class UnsafeCountingFactorizer {
    private long count = 0;
    public long getCount(){
        ++count;
        return count; 
    }
}
```
虽然递增操作++count是 一种紧凑的语法，使其看上去只是一个操作，但这个操作并非原子的，
因而它并不会作为一个 不可分割的操作来执行。实际上，它包含了三个独立的操作：
读取count的值，将值加1,然后 将计算结果写入count。这是一个“读取-修改-写入”的操作序列，
并且其结果状态依赖于 之前的状态。
---
* 延迟初始化中的竞态条件:使用“先检查后执行”的一种常见情况就是延迟初始化。延迟初始化的目的是将对象的初始化操作推迟到实际被使用时才进行。
列：
```java
@NotThreadSafe
public class LazylnitRace {
    private Expensiveθbject instance = null;
    
    public Expensiveθbject getlnstance() {
        if (instance == null)
            instance = new Expensiveθbject();
        return instance;
    }
}

```
假定线程A和 线程B同时执行getlnstanceo A看到instance为空，因而创建一个新的Expensiveθbject实例。
B同样需要判断instance是否为空。此时的instance是否为空，要取决于不可预测的时序, 包括线程的调度方式，
以及A需要花多长时间来初始化Expensiveθbject并设置instanceo如 果当B检查时，instance为空，
那么在两次调用getlnstance时可能会得到不同的结果，即使 getlnstance通常被认为是返回相同的实例。

* 原子变量:将“读取-修改-写入” 作为不可分割的操作来执行及 先检查后执行 CAS 算法
    CAS 算法：
     CAS (Compare-And-Swap) 是一种硬件对并发的支持，针对多处理器操作而设计的处理器中的一种特殊指令，用于管理对共享数据的并发访问。
     CAS 是一种无锁的非阻塞算法的实现。
     CAS 包含了 3 个操作数：
     需要读写的内存值 V
     进行比较的值 A
     拟写入的新值 B
     当且仅当 V 的值等于 A 时，CAS 通过原子方式用新值 B 来更新 V 的值，否则不会执行任何操作。
列：
```java
@ThreadSafe
public class UnsafeCountingFactorizer {
    private final AtomicLong count = new AtomicLong (0);
    public long getCount(){
        count.incrementAndGet();
        return count; 
    }
}
```
在java.util.concurrent.atomic 下包中包含了一些原子变量类，用于实现在数值和对象引用上的原子状态转换。
通过用AtomicLong来代替long类型的计数器，能够确保所有对计数器状态的访问操作都是原子的。
因此这里的类是线程安全的
---
* 注意：原子变量只是通过变量的原子性操作来保证变量的操作属于线程安全~ 在多行代码或有其他业务判断情况就不能保证