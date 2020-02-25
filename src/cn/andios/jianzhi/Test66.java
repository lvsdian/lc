/*
 * @Author: lsd
 * @Date: 2020-02-25 15:30:45
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test67 {
    public int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows < 0 || cols < 0){
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return walk(threshold, rows, cols, 0, 0, visited);
    }
    
    private int walk(int threshold, int rows, int cols, int i, int j, boolean[] visited){
        if(!isLegalPosition(rows, cols, i, j) || visited[i * cols + j] == true
           || bitSum(i) + bitSum(j) > threshold){
            return 0;
        }
        int res = 1;
        visited[i * cols + j] = true;
        res += walk(threshold, rows, cols, i + 1, j, visited) +
            walk(threshold, rows, cols, i - 1, j, visited) +
            walk(threshold, rows, cols, i, j + 1, visited) +
            walk(threshold, rows, cols, i, j - 1, visited);
        return res;
    }
    
    private boolean isLegalPosition(int rows, int cols, int i, int j){
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1){
            return false;
        }
        return true;
    }
    
    public int bitSum(int num){
        int res = num % 10;
        while((num /= 10) != 0){
            res += num % 10;
        }
        return res;
    }
}