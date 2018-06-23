package com.company;

public class ReadTrans extends Thread {
    private MoveAsstets moveAsstets;

    ReadTrans(MoveAsstets moveAsstets) {
        this.moveAsstets = moveAsstets;
    }

    @Override
    public void run () {
        moveAsstets.createTransact();
    }
}
