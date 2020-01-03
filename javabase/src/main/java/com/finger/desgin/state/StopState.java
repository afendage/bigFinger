package com.finger.desgin.state;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
    }

    public String toString(){
        return "Stop State";
    }
}
