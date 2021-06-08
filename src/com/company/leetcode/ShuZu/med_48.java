package com.company.leetcode.ShuZu;

public class med_48 {
    //原地旋转图像
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //先上下交换
        for (int i=0;i< n/2;i++)
        {
            int[] tmp=matrix[i];
            matrix[i]=matrix[n-i-1];
            matrix[n-i-1]=tmp;
        }
//        System.out.println(matrix.toString());
        //再沿主对角线交换（相当于转置）
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
    public void rotate1(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;

        //先沿主对角线交换
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        //再交换左右列
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m/2;j++)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][m-j-1];
                matrix[i][m-j-1]=tmp;
            }
        }

    }


}
