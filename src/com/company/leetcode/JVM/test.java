package com.company.leetcode.JVM;

public class test {

    public void method1(String s)
    {
        int a=10;
        a++;
        System.out.println(a);

        int b=20;
        ++b;
        System.out.println(b);

        int c=10;
        c=c++;
        System.out.println(c);

        int d=20;
        d=++d;
        System.out.println(d);

        int e=10;
        e=e++ + ++e;
        System.out.println(e);
    }


    public static void main(String[] args)
    {
        test t=new test();
        t.method1("this");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
