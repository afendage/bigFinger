import com.finger.desgin.flyweight.connDemo.ConnectionPool;
import com.finger.desgin.flyweight.webSiteDemo.WebSiteFactory;
import com.finger.desgin.flyweight.webSiteDemo.Website;
import org.junit.Test;

import java.sql.Connection;

public class FlyweightTest {

    @Test
    public void websiteTest(){
        WebSiteFactory factory = new WebSiteFactory();
        Website site = factory.getWebsite("博客");
        site.use();
        Website site01 = factory.getWebsite("博客");
        site01.use();
        Website site02 = factory.getWebsite("博客");
        site02.use();
        Website site03 = factory.getWebsite("博客");
        site03.use();
        Website site1 = factory.getWebsite("博客1");
        site1.use();

        System.out.println("连接对象数量:"+factory.getPoolSize());
    }

    @Test
    public void dbConnectionTest() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf-8&serverTimezone=UTC";
        String username="root";
        String password="123456";
        int poolSize =10;
        ConnectionPool pool = new ConnectionPool(driver,url,username,password,poolSize);
        Connection conn = pool.getConnection();
        System.out.println(conn.isClosed());
    }
}
