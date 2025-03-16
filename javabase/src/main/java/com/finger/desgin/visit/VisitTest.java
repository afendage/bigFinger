package com.finger.desgin.visit;

import org.junit.Test;

public class VisitTest {

   @Test
   public void visitest(){
       ComputerPart computer = new Computer();
       computer.accept(new ComputerPartDisplayVisitor());
   }

}
