package com.company;

//import java.io.*;

import java.io.File;

public class Main {


    public static void main(String[] args) throws InterruptedException {
		File file = new File("src\\com\\company\\file.txt");
		MoveAsstets moveAsstets1 = new MoveAsstets(file);
		moveAsstets1.loadFile();
		ReadAcc readAcc = new ReadAcc(moveAsstets1);
		ReadTrans readTrans = new ReadTrans(moveAsstets1);
		readAcc.start();
		readTrans.start();
		readAcc.join();
		readTrans.join();
		moveAsstets1.addBalance();
		moveAsstets1.showResultAcc();
		moveAsstets1.showResultTrans();

    }
}
