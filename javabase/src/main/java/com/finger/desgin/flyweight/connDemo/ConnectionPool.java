package com.finger.desgin.flyweight.connDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {

    private String driver;

    public String url;

    public String username;

    public String password;

    public int poolSize;

    Connection conn=null;

    private Vector<Connection> pool;

    public ConnectionPool(String driver,String url,String username,String password,int poolSize) throws Exception {
        this.driver=driver;
        this.url=url;
        this.username=username;
        this.password=password;
        this.poolSize=poolSize;
        this.initPool();
    }
    private void initPool() throws Exception {
        pool = new Vector<Connection>(poolSize);
        for(int i=0;i<poolSize;i++){
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            pool.add(conn);
        }
    }

    /* 返回连接到连接池 */
    public synchronized void release(){
        pool.add(conn);
    }

    /* 返回连接池中的一个数据库连接 */
    public synchronized Connection getConnection(){
        if(pool.size()>0){
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }else{
            return null;
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
