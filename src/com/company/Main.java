package com.company;

//import java.io.*;

import java.io.File;

public class Main {


    public static void main(String[] args) throws InterruptedException {
		File file = new File("src\\com\\company\\file.txt");
		File file2 = new File("src\\com\\company\\file2.txt");
		MoveAsstets moveAsstets1 = new MoveAsstets(file);
		MoveAsstets moveAsstets2 = new MoveAsstets(file2);
		moveAsstets1.start();
		Thread.sleep(150);
		moveAsstets2.start();

    }
}
