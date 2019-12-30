import com.finger.desgin.memento.Memento;
import com.finger.desgin.memento.Original;
import com.finger.desgin.memento.Storage;
import org.junit.Test;

public class MementoTest {

    @Test
    public void mementoTest(){
        // 创建原始类
        Original original = new Original("11111");

        // 创建备忘录
        Storage storage = new Storage(original.createMemento());

        // 修改原始状态
        System.out.println("原始状态："+original.getValue());
        original.setValue("222222");
        System.out.println("修改后状态："+original.getValue());

        // 还原状态
        original.restoreMemento(storage.getMemento());
        System.out.println("还原后状态："+original.getValue());
    }

}
