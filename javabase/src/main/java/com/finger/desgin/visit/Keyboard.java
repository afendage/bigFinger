package com.finger.desgin.visit;

public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerParVisitor) {
        computerParVisitor.visit(this);
    }
}
