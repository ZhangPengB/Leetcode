package com.company.leetcode.JVM;

import java.util.ArrayList;
import java.util.Random;

public class HeapDemo {
    byte[] buffer=new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args)
    {
        ArrayList<HeapDemo> list = new ArrayList<>();
        while(true)
        {
            list.add(new HeapDemo());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
