import com.finger.desgin.bridge.Driver;
import com.finger.desgin.bridge.DriverManager;
import com.finger.desgin.bridge.MyDriver;
import com.finger.desgin.bridge.MySqlDriver;
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
