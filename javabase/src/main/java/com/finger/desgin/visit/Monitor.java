package com.finger.desgin.visit;

public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerParVisitor) {
        computerParVisitor.visit(this);
    }
}
