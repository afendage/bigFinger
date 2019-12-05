package com.finger.desgin.bridge;

public abstract class DriverManager {

    private Driver driver;

    public String getConnection(){
        return driver.getConnection();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
