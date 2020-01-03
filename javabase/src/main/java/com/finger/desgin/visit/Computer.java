package com.finger.desgin.visit;

public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(),new Keyboard(),new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerParVisitor) {
        for (int i=0;i<parts.length;i++){
            parts[i].accept(computerParVisitor);
        }
        computerParVisitor.visit(this);
    }
}
