//
//import java.util.*;
//import java.io.*;
//
//
//public class t1 {
//    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String[] info = in.nextLine().split(" ");
//            int callNum = Integer.parseInt(info[0]);
//            int rong = Integer.parseInt(info[1]);
//            List<String[]> slist = new LinkedList<>();
//
//            String[] tmp = in.nextLine().split(" ");
//
//            int[] res = new int[24];
//            for (int i = 0; i < 24; i++) {
//                res[i] = 0;
//            }
//            for (int i=0;i<callNum;i++)
//            {
//                int first = Integer.parseInt(tmp[0]); //0
//                int second = Integer.parseInt(tmp[1]);
//                int third = Integer.parseInt(tmp[2]);
//                int sum = 0;
//                for (int i = 0; i < 24; i++) {
//                    sum += res[i];
//                }
//                if (sum + third > rong) {
//                    continue;
//                } else {
//                    res[first] += third;
//                    res[second] -= third;
//                }
//            }
//
//            for (int i = 0; i < 24; i++) {
//                System.out.println(res[i]);
//            }
//        }
//    }
//
//}
//
//
