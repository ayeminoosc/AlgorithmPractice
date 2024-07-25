package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/right-triangles/description/
 */
public class P3128 {
    private int[][] grid;
    public static void main(String[] args) {
        System.out.println(new P3128().numberOfRightTriangles(new int[][]{{0,1,0},{0,1,1},{0,1,0}}));
        System.out.println(new P3128().numberOfRightTriangles(new int[][]{{1,0,0,0},{0,1,0,1},{1,0,0,0}}));
        System.out.println(new P3128().numberOfRightTriangles(new int[][]{{1,0,1},{1,0,0},{1,0,0}}));
        System.out.println(new P3128().numberOfRightTriangles(new int[][]{{1,1,1},{1,0,1}}));
    }

    public long numberOfRightTriangles(int[][] grid) {
        this.grid = grid;
        int row = grid.length;
        int column = grid[0].length;
        int number = 0;
        for(int r=0;r<row;r++){
            List<Integer>rowIndexs = getRow(r);
            if(rowIndexs.size()>1){
                int combination = cominbation(rowIndexs.size());
                for(int i =0;i<rowIndexs.size();i++){
                    int times = getColumn(r, rowIndexs.get(i));
                    number += combination * times;
                }
            }

        }
        return number;
    }

    int cominbation(int n){
     return n -1;
    }
    List<Integer> getRow(int i){
        List<Integer> result = new ArrayList<>();
        int [] rows = this.grid[i];
        for(int j=0;j<rows.length;j++){
            if(rows[j] ==1) result.add(j);
        }
        return result;
    }

    /**
     * return column exluding the one involved
     * @param i
     * @return
     */
    int getColumn(int row, int column){
        if(this.grid[row][column] != 1) return 0;
        int count = 0;
        for(int r =0;r<this.grid.length;r++){
            if(this.grid[r][column]==1) count++;
        }
        return count -1;
    }
}
