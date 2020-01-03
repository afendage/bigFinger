package com.finger.desgin.visit;

public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerParVisitor) {
        computerParVisitor.visit(this);
    }
}
