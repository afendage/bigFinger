import com.finger.desgin.decorator.Docorator;
import com.finger.desgin.decorator.Source;
import com.finger.desgin.decorator.Sourceable;
import org.junit.Test;

public class DocoratorTest {

    @Test
    public void DocoratorTest(){
        Sourceable source = new Source();
        Sourceable sourceable = new Docorator(source);
        sourceable.method();
    }
}
