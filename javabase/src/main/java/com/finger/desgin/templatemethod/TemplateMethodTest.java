package com.finger.desgin.templatemethod;

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
