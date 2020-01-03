import com.finger.desgin.state.Context;
import com.finger.desgin.state.StartState;
import com.finger.desgin.state.StopState;
import org.junit.Test;

public class StateTest {

    @Test
    public void stateTest(){
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }


}
