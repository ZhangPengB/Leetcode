package com.company.leetcode.JVM;

public class Main {
    private static int count=0;

    private static void hello()
    {
        System.out.println("hello!");
    }

    public static void main(String[] args) {

//        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
//        System.out.println(sysClassLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2
//
//        //自定义类使用系统类加载器来获取
//        ClassLoader curClassloader=Main.class.getClassLoader();
//        System.out.println(curClassloader);  //sun.misc.Launcher$AppClassLoader@18b4aac2
//
//        //系统类使用扩展类加载器加载
//        ClassLoader extClassLoader = sysClassLoader.getParent();  //sun.misc.Launcher$ExtClassLoader@1b6d3586
//        System.out.println(extClassLoader);
//
//
//        //string类是由引导类加载器加载->java核心类库都是由引导类加载器加载
//        ClassLoader stringLoader=String.class.getClassLoader();
//        System.out.println(stringLoader);  //null
//        System.out.println(extClassLoader.getParent());  //null
//
//        //启动类加载器
//        URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        System.out.println(urls.length);
//        for (URL e:urls)
//        {
//            System.out.println(e.toExternalForm());
//        }
//        System.out.println(Provider.class.getClassLoader());
//
//        try {
//            ClassLoader classLoader=Class.forName("java.lang.String").getClassLoader();
//            System.out.println(classLoader);  //null
//            //获取当前应用程序（类）加载器
//            System.out.println(Thread.currentThread().getContextClassLoader());
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Main m=null;
        m.hello();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        main(args);  //StackOverflowError


    }
}
