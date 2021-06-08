package com.company.leetcode.dp;

/*
* dp[i][j]:进入位置(i,j)之前，所摘得樱桃总个数
* 递推公式：dp[i][j]=max(dp[i-1][j],dp[i][j-1])+grid[i][j]
* */

public class hard_741 {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][] grid1=grid;
        int[][] dp=new int[n+1][n+1];

        dp[0][0]=0;
        dp[0][1]=0;
        dp[1][0]=0;


        for (int i=2;i<n;i++)
        {
            dp[i][0]=Integer.MIN_VALUE;
            dp[0][i]=Integer.MIN_VALUE;
        }


        //正向摘
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                if (grid1[i-1][j-1]!=-1)  //该位置可通过
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid1[i-1][j-1];
                    grid1[i-1][j-1]=0;
                }
                else dp[i][j]=0;  //该位置为荆棘，不可通过，可摘樱桃个数为0
            }
        }

        int maxRes=dp[n][n];
        System.out.println(maxRes);

        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid1[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

//        //恢复grid:
//        for (int i=0;i<n;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                if (dp[i+1][j]>dp[i][j+1])
//                {
//                    grid1[i][j+1]=grid[i][j+1];
//                }
//            }
//        }

        for (int i=0;i<=n;i++)
        {
            for (int j=0;j<=n;j++)
            {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        //反向摘
        int[][] dpRrverse=new int[n+1][n+1];
        dpRrverse[n][n]=0;
        dpRrverse[n][n-1]=0;
        dpRrverse[n-1][n]=0;

        //初始化
        for (int i=n-2;i>=0;i--)
        {
            dpRrverse[i][n]=Integer.MIN_VALUE;
            dpRrverse[n][i]=Integer.MIN_VALUE;
        }

        for (int i=n-1;i>=0;i--)
        {
            for (int j=n-1;j>=0;j--)
            {
                if (grid[i][j]!=-1)  //可通过
                {
                    dpRrverse[i][j]=Math.max(dpRrverse[i][j+1],dpRrverse[i+1][j])+grid[i][j];
                    grid[i][j]=0;
                }
                else dpRrverse[i][j]=0;
            }
        }
        int reverseRes=dpRrverse[0][0];
        System.out.println(reverseRes);

        return reverseRes+maxRes;
    }
}
