package com.company.leetcode.JVM;

public class StringTest {

    public void test() {
        System.out.printf("test");
        String s = new String("1") + new String("1");
        String s1 = "11";
        System.out.println(s == s1);  //false
        String s2 = s.intern();
        System.out.println(s2 == s1);  //true
        System.out.println(s2 == s);  //false
        System.out.println(s==s1);  //false
    }

    public static void main(String[] args) {


//        String s = new String("11");
        String s = new String("1") + new String("1");
        s.intern();  //在调用intern() 方法之前，字符串常量池中已经存在“11”，所以s指向的仍为堆空间对象地址
        String s2 = "11";
        System.out.println(s == s2);  //false

//
//        //拼接操作
//        //
//        String s3 = new String("1") + new String("1");
//        //执行完上一行代码后，字符串常量池中是否存在“11”呢？不存在！
//        String s5 = s3.intern();
//        //jdk6,调用intern()方法后，在堆空间建了一个新的对象，也就有了一个新地址
//        //jdk7以后，在调用intern()方法之前，字符串常量池中不存在“11”，调用intern()方法后在字符串常量池中也并未生成“11”，而是创建一个指向堆空间对象的引用
//        String s4 = "11";  //s4变量记录的地址：使用的是上一行代码执行时，在常量池中生成“11”的地址
//        System.out.println(s3 == s4);  //true
//        System.out.println(s3 == s5); //true
//        System.out.println(s4 == s5);  //true
//
//        new StringTest().test();
    }
}
