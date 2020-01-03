import com.finger.desgin.visit.Computer;
import com.finger.desgin.visit.ComputerPart;
import com.finger.desgin.visit.ComputerPartDisplayVisitor;
import org.junit.Test;

public class visitTest {

   @Test
   public void visitest(){
       ComputerPart computer = new Computer();
       computer.accept(new ComputerPartDisplayVisitor());
   }

}
