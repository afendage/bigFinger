import com.finger.desgin.command.Command;
import com.finger.desgin.command.Invoker;
import com.finger.desgin.command.MyCommand;
import com.finger.desgin.command.Receiver;
import org.junit.Test;


public class CommandTest {


    @Test
    public void commandTest(){
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
