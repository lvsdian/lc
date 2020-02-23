/*
 * @Author: lsd
 * @Date: 2020-02-22 00:15:28
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.ArrayList;

public class Test19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //非空判断
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return list;
        }
        int up = 0,left = 0,right = matrix[0].length - 1,down = matrix.length - 1;
        while(true){
            //从左上到右上
            for(int col = left;col <= right;col ++){
                list.add(matrix[up][col]);
            }
            up ++;
            if(up > down){
                break;
            }
            //从右上到右下
            for(int row = up;row <= down;row ++){
                list.add(matrix[row][right]);
            }
            right --;
            if(left > right){
                break;
            }
            //从右下到左下
            for(int col = right;col >= left;col --){
                list.add(matrix[down][col]);
            }
            down --;
            if(down < up){
                break;
            }
            //从左下到左上
            for(int row = down;row >= up;row --){
                list.add(matrix[row][left]);
            }
            left ++;
            if(right < left){
                break;
            }
        }
        return list;
     }
}