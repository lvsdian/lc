/*
 * @Author: lsd
 * @Date: 2020-02-25 15:27:43
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || matrix.length != rows * cols || str == null){
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                //以矩阵中的每个点作为起点尝试走出str对应的路径
                if(hasPathCore(matrix, rows, cols, i, j, str, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //当前在矩阵的(i,j)位置上
    //index -> 匹配到了str中的第几个字符
    private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, 
                                char[] str, int index, boolean[] visited){
        if(index == str.length){
            return true;
        }
        //越界或字符不匹配或该位置已在路径上
        if(!match(matrix, rows, cols, i, j, str[index]) || visited[i * cols + j] == true){
            return false;
        }
        visited[i * cols + j] = true;
        boolean res = hasPathCore(matrix, rows, cols, i + 1, j, str, index + 1, visited) ||
            hasPathCore(matrix, rows, cols, i - 1, j, str, index + 1, visited) ||
            hasPathCore(matrix, rows, cols, i, j + 1, str, index + 1, visited) ||
            hasPathCore(matrix, rows, cols, i, j - 1, str, index + 1, visited);
        visited[i * cols + j] = false;
        return res;
    }
    
    //矩阵matrix中的(i,j)位置上是否是c字符
    private boolean match(char[] matrix, int rows, int cols, int i, int j, char c){
        if(i < 0 || i > rows - 1 || j < 0 || j > cols - 1){
            return false;
        }
        return matrix[i * cols + j] == c;
    }
}