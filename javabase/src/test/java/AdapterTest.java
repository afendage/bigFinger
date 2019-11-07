import com.finger.desgin.adapter.Adapter;
import com.finger.desgin.adapter.Targetable;
import org.junit.Test;

public class AdapterTest {

    @Test
    public void classAdapterTest(){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

}
