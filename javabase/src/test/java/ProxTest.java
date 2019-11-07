import com.finger.desgin.prox.staticProx.Prox;
import com.finger.desgin.prox.staticProx.Sourceable;
import org.junit.Test;

public class ProxTest {

    @Test
    public void staticPorxTest(){
        Sourceable sourceable = new Prox();
        sourceable.method();
    }

}
