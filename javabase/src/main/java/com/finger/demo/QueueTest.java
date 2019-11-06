package com.finger.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueTest {

    /**
     * 队列-先入先出
     */
    @Test
    public void t(){
        Queue<String> queue = new LinkedList();
        queue.offer("元素A");
        queue.offer("元素B");
        queue.offer("元素C");
        queue.offer("元素D");
        queue.offer("元素E");
        while (queue.size() > 0) {
            String element = queue.poll();
            System.out.println(element);
        }
    }

    /**
     * 栈-先入后出
     */
    @Test
    public void t1(){
        Stack<String> stack= new Stack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        while (stack.size() > 0){
            String item = stack.pop();
            System.out.println(item);
        }
    }
}
