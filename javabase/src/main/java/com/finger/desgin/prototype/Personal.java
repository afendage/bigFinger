package com.finger.desgin.prototype;

import java.io.*;

public class Personal implements Cloneable , Serializable {

    private String name;

    private int age;

    private Student student;

    /**
     * 浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    public Personal clone() throws CloneNotSupportedException {
        return (Personal) super.clone();
    }

    /**
     * 深复制
     * @return
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
