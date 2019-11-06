import com.finger.desgin.singleton.Singleton;
import org.junit.Test;

public class singletonTest {

    @Test
    public void singletonTest(){
        Singleton singleton = Singleton.getInstance();

        Singleton singleton1 = Singleton.getSynInstance();

        Singleton singleton2 = Singleton.getSynOptInstance();

        Singleton singleton3 = Singleton.getInsideInstace();

        Singleton singleton4 = Singleton.getEnumInstance();

        System.out.println(singleton==singleton1);
        System.out.println(singleton==singleton2);
        System.out.println(singleton==singleton3);
        System.out.println(singleton==singleton4);
    }

}
