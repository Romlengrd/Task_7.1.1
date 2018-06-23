package com.company;

import java.io.*;
import java.util.TreeSet;

class MoveAsstets extends Thread {
    //private int n;
    private int[] id;
    private int[] ids;
    private int[] balance;
    private int[] targetId;
    private int[] value;
    private int l;
    private File file;

    //MoveAsstets () {}

    MoveAsstets(File file) {
        this.file = file;
    }

     private void loadFile() {
        synchronized (this) {
            try (FileReader fileReader = new FileReader(file)) {
                String[] trans;
                String string;
                StringBuilder string2 = new StringBuilder();
                BufferedReader br = new BufferedReader(fileReader);
                while ((string = br.readLine()) != null) {
                    string2.append(string).append(" ");
                }
                //System.out.println(string2);
                trans = string2.toString().split("=|\\s");
//            for (String data : trans) {
//                System.out.println(data);
//            }
                id = new int[trans.length / 8];
                balance = new int[trans.length / 8];
                targetId = new int[trans.length / 8];
                value = new int[trans.length / 8];
                //n = id.length;

                int j;
                int mc;

                TreeSet<Integer> idSet = new TreeSet<>();
                for (int i = 1; i < trans.length; ) {
                    idSet.add(Integer.parseInt(trans[i]));
                    i += 8;
                }
                Integer[] a = idSet.toArray(new Integer[0]);
                ids = new int[a.length];
                l = ids.length;
                for (int i = 0; i < a.length; i++) {
                    ids[i] = a[i];
                }

                System.out.println();
                mc = 0;
                for (j = 1; j < trans.length - 6; ) {
                    id[mc] = Integer.parseInt(trans[j]);
                    j += 8;
                    mc++;
                }


                mc = 0;
                for (j = 5; j < trans.length - 2; ) {
                    balance[mc] = Integer.parseInt(trans[j]);
                    j += 8;
                    mc++;
                }
                mc = 0;
                for (j = 3; j < trans.length - 4; ) {
                    targetId[mc] = Integer.parseInt(trans[j]);
                    j += 8;
                    mc++;
                }
                mc = 0;
                for (j = 7; j < trans.length; ) {
                    value[mc] = Integer.parseInt(trans[j]);
                    j += 8;
                    mc++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Transaction[] transactions;
    private void createAccounts() {

        Account[] accounts = new Account[l];

        synchronized (this) {
            System.out.println("Список Аккунтов:");
            for (int i = 0; i < l; i++) {
                accounts[i] = new Account(0, ids[i]);
                for (Transaction transaction : transactions) {
                    if (transaction.getId() == i + 1) {
                        accounts[i].setBalance(transaction.getBalance());
                    }
                }
                System.out.println(accounts[i]);
            }

        }

    }


    private void createTransact() {
        transactions = new Transaction[id.length];

        synchronized (this) {
            System.out.println("Список считанных транзакций:");
            for (int i = 0; i < id.length; i++)
                if ((id[i] != 0) || (targetId[i] != 0) || (balance[i] != 0) || (value[i] != 0)) {
                    transactions[i] = new Transaction();
                    transactions[i].setId(id[i]);
                    transactions[i].setTargetId(targetId[i]);
                    transactions[i].setBalance(balance[i]);
                    transactions[i].setValue(value[i]);
                    System.out.println(transactions[i]);
                }

        }

    }

    @Override
    public void run () {

        loadFile();
        createTransact();
        createAccounts();


    }



}
