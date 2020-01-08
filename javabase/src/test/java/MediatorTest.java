import com.finger.desgin.mediator.Mediator;
import com.finger.desgin.mediator.MyMediator;
import org.junit.Test;

public class MediatorTest {

    @Test
    public void mediatorTest(){
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }

}
