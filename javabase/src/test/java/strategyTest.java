import com.finger.desgin.strategy.ICalculator;
import com.finger.desgin.strategy.Minus;
import com.finger.desgin.strategy.Multiply;
import com.finger.desgin.strategy.Plus;
import org.junit.Test;

public class strategyTest {

    @Test
    public void calculatorTest(){
        ICalculator cl = new Plus();
        int i = cl.calculator("1+1");
        System.out.println(i);

        ICalculator c2= new Minus();
        int j = c2.calculator("2-2");
        System.out.println(j);

        ICalculator c3 = new Multiply();
        int k = c3.calculator("3*3");
        System.out.println(k);
    }
}
