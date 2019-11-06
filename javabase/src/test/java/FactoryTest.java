import com.finger.desgin.factory.methodFactory.QqFactory;
import com.finger.desgin.factory.simpleFactory.Sender;
import com.finger.desgin.factory.simpleFactory.SenderFactory;
import com.finger.desgin.factory.methodFactory.EmailFactory;
import com.finger.desgin.factory.methodFactory.Provider;
import org.junit.Test;

public class FactoryTest {

    // 优点：代码直观
    // 缺点：如果修改， 需要修改原来的代码，不符合代码的开闭原则（对扩展开放，对修改关闭）
    // 简单工厂-传参判断模式
    @Test
    public void simpleFactoryTest(){
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produce("email");
        sender.send();

        Sender sender1 = factory.produce("sms");
        sender1.send();
    }

    // 简单工厂-多方法模式
    @Test
    public void simpleFactoryTest1(){
        SenderFactory factory = new SenderFactory();
        factory.produceEmail().send();
        factory.produceSms().send();

        // 静态多发模式
        SenderFactory.produceEmail1().send();
    }

    /**
     * 工厂方法
     */
    @Test
    public void methodFactoryTest(){
        Provider provider = new EmailFactory();
        com.finger.desgin.factory.methodFactory.Sender sender = provider.produce();
        sender.send();
    }

    // 扩展- 加一个工厂，一个实现类即可
    // 优点：无需修改代码，符合开闭原则（对扩展开放，对修改关闭）
    // 缺点：扩展类比较多，每次新加业务都需要新增类
    @Test
    public void methodFactoryTest1(){
        Provider provider = new QqFactory();
        com.finger.desgin.factory.methodFactory.Sender sender= provider.produce();
        sender.send();
    }
}
