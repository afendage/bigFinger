#并发编程实战
---
##什么是线程安全性
---
###StatelessFactorizer
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