package com.finger.desgin.Iterator;

import org.junit.Test;

public class IteratorTest {

    @Test
    public void iteratorTest(){
        Collection collection = new MyCollection();
        collection.set("A");
        collection.set("B");
        collection.set("C");
        collection.set("D");

        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(it.first());
        System.out.println(it.previous());
    }

}
