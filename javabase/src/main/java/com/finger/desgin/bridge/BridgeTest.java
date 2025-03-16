package com.finger.desgin.bridge;

import org.junit.Test;

public class BridgeTest {

    @Test
    public void driverTest(){
        DriverManager manager = new MyDriver();
        Driver driver = new MySqlDriver();
        manager.setDriver(driver);
        String conn = manager.getConnection();
        System.out.println(conn);
    }

}
