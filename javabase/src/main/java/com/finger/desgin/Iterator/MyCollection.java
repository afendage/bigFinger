package com.finger.desgin.Iterator;

import java.util.Arrays;

public class MyCollection implements Collection{

    String [] array=new String[0];

    public Iterator iterator(){
        return new MyIterator(this);
    }

    public void set(String str){
        int i = this.size();
        array = Arrays.copyOf(array,array.length + 1);
        array[i] = str;
    }

    public Object get(int i) {
        return array[i];
    }

    public int size() {
        return array.length;
    }
}
