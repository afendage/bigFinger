import com.finger.desgin.templatemethod.Student;
import com.finger.desgin.templatemethod.Teacher;
import com.finger.desgin.templatemethod.TestPaper;
import org.junit.Test;

public class TemplateMethodTest {

    @Test
    public void testPaperTest(){
        TestPaper paper = new Teacher();
        paper.question();

        TestPaper anst = new Student();
        anst.answer();
    }

}
