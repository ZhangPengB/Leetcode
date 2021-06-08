package com.company.leetcode.JVM;

public class StringTest {

    public static void test() {
        System.out.println("test");
        String s = new String("1") + new String("1");  //new出的对象放在堆空间，字符串变量s放在栈空间（存放指向堆空间地址）
        String s1 = "11";  //s1指向字符串常量池
        System.out.println(s == s1);  //false
        String s2 = s.intern();  //调用intern返回一个指向字符串常量池的变量引用
        System.out.println(s2 == s1);  //true
        System.out.println(s2 == s);  //true
    }

    public static void main(String[] args) {

        //==运算符用来判断两个对象是否指向同一个内存地址
//        String s = new String("11");
        String s = new String("1") + new String("1");
        s.intern();  //调用intern方法至后，jvm在字符串常量池中放一份'11',此时s指向字符串常量池
        String s2 = "11";
        System.out.println(s == s2);  //true
        test();
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
