package com.finger.exception;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 运行时常见异常案列
 *  NullPointerException            空指针异常
 *  ArrayIndexOutOfBoundsException  数组下标越界
 *  IndexOutOfBoundsException       下标越界异常
 *  ArithmeticException             算术异常(数学运算错误)
 *  ClassCastException              类型转换异常
 *  NumberFormatException           数字格式异常
 *  ConcurrentModificationException  并发修改异常
 *  FileNotFoundException           文件无法找到
 *  SQLException                    数据库异常
 *  ClassNotFoundException          类未找到异常
 *  TimeoutException                操作超时
 */
public class RuntimeExceptionDemo {

    /**
     * NullPointerException 空指针异常
     */
    @Test
    public void NullPointerExceptionTest(){
        String str = null;
        System.out.println(str.length());

        // 应该使用前判断
        /*if (str != null) {
            System.out.println(str.length());
        }*/
    }

    /**
     * ArrayIndexOutOfBoundsException 数组下标越界
     */
    @Test
    public void ArrayIndexOutOfBoundsExceptionTest(){
        int [] arr = {1,2,3};
        System.out.println(arr[3]);

        // 应该获取 arr 最大值
        //System.out.println(arr[arr.length-1]);
    }

    /**
     * IndexOutOfBoundsException 下标越界异常
     */
    @Test
    public void IndexOutOfBoundsExceptionTest(){
        List<String> list = new ArrayList<>();
        System.out.println(list.get(0));

        // 先判断集合大小
        /*if (!list.isEmpty()) {
            String item = list.get(0);
        }*/
    }

    /**
     * ArithmeticException 算术异常(数学运算错误)
     */
    @Test
    public void ArithmeticExceptionTest(){
        int result = 10 / 0;
    }

    /**
     * ClassCastException  类型转换异常
     */
    @Test
    public void ClassCastExceptionTest(){
        Object str ="ABC";
        Integer i = (Integer) str;

        // 应该判断类型后操作
        /*if (str instanceof Integer){
            Integer i = (Integer) str;
        }*/
    }

    /**
     * NumberFormatException 数字格式异常
     */
    @Test
    public void NumberFormatExceptionTest(){
        String str = "abc";
        int num = Integer.parseInt(str);
    }

    /**
     * ConcurrentModificationException  并发修改异常  ->单线程遍历时直接删除元素（经典案例）
     *  ArrayList 的内部迭代器（Itr） 在遍历时会记录 modCount（集合修改次数）。
     *  当你调用 fruits.remove() 时，modCount 会增加，但迭代器的 expectedModCount 不会更新。
     *  下次调用 next() 时，迭代器会检查 modCount != expectedModCount，如果发现不一致，就抛出 ConcurrentModificationException
     */
    @Test
    public void ConcurrentModificationExceptionTest(){
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Pear");  // 增加一个元素，确保遍历会继续
        fruits.add("Orange");

        for (String fruit : fruits) {
            if (fruit.equals("Banana")) {
                fruits.remove(fruit);  // 删除后，Iterator 仍会尝试 next()，触发异常
            }
            System.out.println("当前遍历到: " + fruit);
        }

        // 应使用迭代器来删除
        /*Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                iterator.remove();  // 安全删除
            }
        }*/
    }

    /**
     * ConcurrentModificationException  并发修改异常（多线程）
     *  ArrayList 不是线程安全的：
     *  ArrayList 的 modCount（修改计数器）没有同步保护，多线程并发修改会导致 modCount 不一致。
     *  线程 1 的 Iterator 在遍历时记录了初始的 modCount（expectedModCount）。
     *  线程 2 修改集合后，modCount 增加，但线程 1 的 Iterator 仍然用旧的 expectedModCount 检查，发现不一致后抛出异常。
     */
    @Test
    public void ConcurrentModificationExceptionByMultiThread() {
        List<String> fruits = new ArrayList<>();
//        List<String> fruits = new CopyOnWriteArrayList<>();       // 正确写法~ 应该使用 并发集合
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // 线程1：遍历集合（多次循环，增加碰撞概率）
        Thread iteratorThread = new Thread(() -> {
            Iterator<String> iterator = fruits.iterator();
            while (iterator.hasNext()) {
                String fruit = iterator.next();
                System.out.println(Thread.currentThread().getName() + " 遍历到: " + fruit);
                try {
                    Thread.sleep(100); // 缩短休眠时间，增加并发冲突
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 线程2：频繁修改集合
        Thread modifierThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) { // 大量修改
                fruits.add("NewFruit-" + i);
                System.out.println(Thread.currentThread().getName() + " 添加了: NewFruit-" + i);
                try {
                    Thread.sleep(50); // 缩短休眠时间，增加并发冲突
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        iteratorThread.start();
        modifierThread.start();

        // 等待线程结束（避免测试方法提前退出）
        try {
            iteratorThread.join();
            modifierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileNotFoundException 文件无法找到
     */
    @Test
    public void FileNotFoundExceptionTest(){
        try {
            FileInputStream fis = new FileInputStream("不存在.txt"); // 抛出 FileNotFoundException（IOException 子类）
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SQLException 数据库异常
     */
    @Test
    public void SQLExceptionTest(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "wrong_password"); // 抛出 SQLException
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ClassNotFoundException 类未找到异常
     */
    @Test
    public void ClassNotFoundExceptionTest(){
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  TimeoutException    操作超时
     */
    @Test
    public void TimeoutExceptionTest(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> callRemoteService());
        try {
            // 设置超时时间为 2 秒
            String response = future.get(2, TimeUnit.SECONDS);
            System.out.println("Response: " + response);
        } catch (TimeoutException e) {
            System.err.println("Error: 服务调用超时，请检查服务B状态或网络延迟！");
            e.printStackTrace();
            future.cancel(true); // 取消任务，释放资源
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
    // 模拟服务B处理延迟（例如：3秒）
    private static String callRemoteService() {
        try {
            Thread.sleep(3000);  // 模拟服务B处理延迟（例如：3秒）
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data from Service B";
    }
}
