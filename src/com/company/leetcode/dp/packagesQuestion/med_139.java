package com.company.leetcode.dp.packagesQuestion;

import java.util.*;

public class med_139 {
    //使用记忆化数组加回溯，通过！！！
    private static boolean backTracking(String s, int startIndex, Set<String> hs, int[] memory) {
        if (startIndex >= s.length()) {
            return true;
        }

        //如果记忆化数组不是初始值了，直接使用结果值
        if (memory[startIndex] != -1) return memory[startIndex] == 1;
        //横向遍历和纵向递归
        for (int i = startIndex; i < s.length(); i++) {
            System.out.println(startIndex + "---" + i);
            String word = s.substring(startIndex, i + 1);
            if (hs.contains(word) && backTracking(s, i + 1, hs, memory)) {
                memory[startIndex] = 1;   //记录以startIndex开始字符串是可以被拆分的
                return true;
            }
        }
        memory[startIndex] = 0;   //记录以startIndex开始的字符串是不可以被拆分的
        return false;
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
//        for(String str:hs)   //遍历哈希集合
//        {
//            System.out.println(str);
//        }
        int[] memory = new int[s.length()];
        Arrays.fill(memory, -1);
        return backTracking(s, 0, hs, memory);
    }


    //动态规划解决
    //dp[i]表示以i结尾的字符串（不包含下标为i的字符）是否包含单词字典中的单词，若包含，为true,否则为false
    //递推公式：dp[i]=dp[j] && s[j:i] in wordDict （子字符串以j开头），两者均满足时，为true，否则为false
    // 初始化：dp[0]=true,其他为false
    //遍历顺序：题目可看成用wordDict中的元素物品来装满字符串这个背包，物品可以无限使用，因此可看成一个完全背包问题，对于完全背包问题的两种遍历顺序
    //1、如果是求组合问题，与顺序无关，物品遍历放在外部循环
    //2、如果是求排列问题，与顺序有关，物品遍历放在内部
    //该题目既不是求组合，也不是求排列，而是求物品元素是否出现在背包中，因此哪个遍历在内外都无关紧要
    //
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> S = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)   //遍历背包（字符串）,这里表示以下标i结尾的字符串
        {
            for (int j = 0; j < i; j++)    //遍历物品(截取子字符串），这里截取以下标i结尾的子字符串
            {
                String word = s.substring(j, i);  //截取
                if (S.contains(word) && dp[j]) {
                    System.out.println(word);
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> S = new HashSet<>(wordDict);

        int start = 0;
        for (int i = 0; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (S.contains(word)) {
                start = i;
            }
        }
        System.out.println(start);
        return start == s.length();
    }


    public static void main(String[] args) {
        String s = "aaaaaaa";
//        String[] wordDict = {"leet", "code"};
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(wordBreak1(s, wordDict));
    }
}
