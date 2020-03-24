[toc]

1. 计数
   - 有多少种方法走到右下角
   - 有多少种方法选出k个数使得和是sum
2. 求最大值、最小值
   - 从左上角走到右下角路径的最大数字和
   - 最长上升子序列
3. 求存在性
   - 取石子游戏，先手是否必胜
   - 能不能选出k个数使得和是sum



#### 确定状态

##### 最后一步

##### 子问题 

#### 转移方程

#### 初始条件、边界情况                      

#### 计算顺序



### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

> 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

> 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

> 示例 1:
>
> 输入: [1,2,3,1]
> 输出: 4
> 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
>      偷窃到的最高金额 = 1 + 3 = 4 。

> 示例 2:
>
> 输入: [2,7,9,3,1]
> 输出: 12
> 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
>      偷窃到的最高金额 = 2 + 9 + 1 = 12 。

solution 1

> 暴力：`resolve(int idx,int[] nums)`表示第`idx`家抢；边界：`idx < 0`；最后一家，可能抢，可能不强，对于抢好还是不抢好，用`Math.max()`来选择，所以解法如下：

```java
class Solution {
    public int rob(int[] nums) {
        return resolve(nums.length - 1,nums);
    }
    
    public int resolve(int idx,int[] nums){
        if(idx < 0){
            return 0;
        }
        return Math.max(
                nums[idx] + resolve(idx - 2,nums),
                resolve(idx - 1,nums)
            );
    }
}
```

solution 2

> 1. 非空判断：判断nums是否为空
>
> 2. 确定状态：`dp[i]`表示打劫前`i`家的最大收益总和
>
> 3. 转移方程：对于nums[i]的最大收益，如果打劫，收益：nums[i] + dp[i - 2]，如果不打劫，收益：      dp[i - 1]，
>
> 4. 边界：dp[0] = 0,dp[1] = nums[0]
>
> 5. 计算顺序：0,1边界列出来了，就从2开始计算

```java
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int [nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i <= nums.length;i ++){
            dp[i] = Math.max(
                    dp[i - 2] + nums[i - 1],
                    dp[i - 1] 
                );
        }
        return dp[nums.length];
    }
}
```

### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

> 一个机器人位于一个 m(横) x n (纵)网格的左上角 。

> 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。

> 问总共有多少条不同的路径？

> 示例 1:

> 输入: m = 3, n = 2
> 输出: 3
> 解释:
> 从左上角开始，总共有 3 条路径可以到达右下角。

> 向右 -> 向右 -> 向下
>
> 向右 -> 向下 -> 向右
>
> 向下 -> 向右 -> 向右

> 示例 2:

> 输入: m = 7, n = 3
> 输出: 28

solution 

> 1. 非空判断：判断m,n是否为0
>
> 2. 确定状态：dp[i]\[j]表示第i行，第j列的路径条数
>
> 3. 转移方程：f(m,n) = f(m - 1,n ) + f(m ,n - 1)
>
> 4. 边界：第1行或第1列到达的路径条数只能为1
>
> 5. 计算顺序：遍历

```java
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for(int i = 1;i <= m;i ++){
            for(int j = 1;j <= n;j ++){
                if(i == 1 || j == 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] +  dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
```

### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

> 给定一个包含非负整数的 *m* x *n* 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

>  **说明：**每次只能向下或者向右移动一步。

**示例:**

```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

solution 

> 1. 非空判断：gird数组是否为null
>
> 2. 确定状态：dp[i]\[j]表示到达第i行，第j列的最短路径
>
> 3. 转移方程：f(m,n) = Math.min( f(m - 1,n ) + f(m ,n - 1) ) + grid[i]\[j]
>
> 4. 边界：到达第1行或第1列上的点只有一种方法到达，所以可以单独算出来
>
> 5. 计算顺序：遍历

```java
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i = 1;i < m;i ++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1;j < n;j ++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1;i < m;i ++){
            for(int j = 1;j < n;j ++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];;                
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

> 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

> 你可以对一个单词进行如下三种操作：

> 插入一个字符
> 删除一个字符
> 替换一个字符

> 示例 1:

> 输入: word1 = "horse", word2 = "ros"
> 输出: 3
> 解释: 
> horse -> rorse (将 'h' 替换为 'r')
> rorse -> rose (删除 'r')
> rose -> ros (删除 'e')

> 示例 2:

> 输入: word1 = "intention", word2 = "execution"
> 输出: 5
> 解释: 
> intention -> inention (删除 't')
> inention -> enention (将 'i' 替换为 'e')
> enention -> exention (将 'n' 替换为 'x')
> exention -> exection (将 'n' 替换为 'c')
> exection -> execution (插入 'u')

> 1. 非空判断
> 2. 确定状态：dp[i]\[j]表示长度为i的word1转为长度为j的word2所需的最少操作次数
> 3. 转移方程：word1[i]表示word1第i个元素，word2[j]表示word2第j个元素，如果两个相等，那么dp[i]\[j] = dp[i - 1]\[j - 1]，如果两个不相等，dp[i]\[j] = min(dp[i]\[j - 1],dp[i - 1]\[j],dp[i - 1]\[j - 1]) + 1，即增删改
> 4. 边界：word1为“”或者word为“”
> 5. 计算
>
> 如果dp长度设为len1,len2，不是len1 + 1,len2 + 1，那么设置边界时就要从0开始，再下面的循环中，也要从0开始，比较word1.charAt(i) = word2.charAt(j)，但又涉及到 i - 1,j - 1，所以对0要做特判，dp长度直接用len1 + 1，len2 + 1就不用了

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //确定状态 dp[i][j]表示word1前i个与word2前j个的最短编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        //转移方程，word1[i]==word2[j]：word1[i]这个字符==word2[j]这个字符
        // word1[i]==word2[j]：dp[i][j] = dp[i - 1][j - 1]
        // word1[i]!=word2[j]：dp[i][j] = min(dp[i][j - 1],dp[i - 1][j],dp[i - 1][j - 1])

        //边界
        for(int i = 1;i <= len1;i ++){
            dp[i][0] = i;
        }
        for(int i = 1;i <= len2;i ++){
            dp[0][i] = i;
        }
        for(int i = 1;i <= len1;i ++){
           for(int j = 1;j <= len2;j ++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i][j - 1]),dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
```



### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

> 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

> 示例:

> 输入: [-2,1,-3,4,-1,2,1,-5,4],
> 输出: 6
> 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

> 1. 非空判断：nums是否为null
> 2. 确定状态：dp[i]表示以i为结束点的子数组的最大和
> 3. 转移方程：dp[i] = Math.max(dp[i - 1],0) + nums[i]
> 4. 边界：dp[0] = nums[0]
> 5. 计算

```java
public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0){
        return 0;
    }
    //dp[i]表示以i为结尾的连续子数组的和
    int[] dp = new int[nums.length];

    dp[0] = nums[0];

    int max = Integer.MIN_VALUE;

    for(int i = 1;i <= nums.length - 1;i ++){
        dp[i] = Math.max(dp[i - 1],0) + nums[i];
        max = Math.max(dp[i],max);
    }
    return Math.max(dp[0],max);
}
```

### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

> 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

> 例如，给定三角形：

> [
>      [2],
>     [3,4],
>    [6,5,7],
>   [4,1,8,3]
> ]
> 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）

> 1. 非空判断：triangle是否为null
> 2. 确定状态：dp[i]\[j]表示表示i行j列的最小值
> 3. 转移方程：dp[i][j] = Math.min(dp[i + 1]\[j],dp[i + 1]\[j + 1]) + triangle.get(i).get(j)
> 4. 边界：最后一层确定，就是它本身
> 5. 计算

```java
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int h = triangle.size();
        //确定状态，dp[i][j]表示i行j列的最小值
        int[][] dp = new int[h][triangle.get(h - 1).size()];

        //dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + triangle.get(i).get(j);

        //边界,最后一层
        for(int i = 0;i < triangle.get(h - 1).size();i ++){
            dp[h - 1][i] =  triangle.get(h - 1).get(i);
        }
        
        for(int i = h - 2;i >= 0;i --){
            for(int j = 0;j < triangle.get(i).size();j ++){
                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
```

