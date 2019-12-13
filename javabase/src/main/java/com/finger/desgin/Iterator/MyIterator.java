package com.finger.desgin.Iterator;

public class MyIterator implements Iterator{

    private Collection collection;

    private int position = -1;

    public MyIterator(Collection collection){
        this.collection=collection;
    }

    public Object previous() {
        if(position>0){
            position--;
            return collection.get(position);
        }
        return null;
    }

    public Object next() {
        if(position<collection.size()-1){
            position++;
            return collection.get(position);
        }
        return null;
    }

    public boolean hasNext() {
        if(position<collection.size()-1){
            return true;
        }
        return false;
    }

    public Object first() {
        return collection.get(0);
    }
}
