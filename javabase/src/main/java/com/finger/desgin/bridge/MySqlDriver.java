package com.finger.desgin.bridge;

public class MySqlDriver implements Driver{
    public String getConnection() {
        return "mysql connection";
    }
}
