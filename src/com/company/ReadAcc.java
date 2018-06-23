package com.company;

public class ReadAcc extends Thread {
    private MoveAsstets moveAsstets;

    ReadAcc(MoveAsstets moveAsstets) {
        this.moveAsstets = moveAsstets;
    }

    @Override
    public void run () {
        moveAsstets.createAccounts();
    }
}
