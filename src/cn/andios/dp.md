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

### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

> 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

> 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

> 注意：你不能在买入股票前卖出股票。

> 示例 1:

> 输入: [7,1,5,3,6,4]
> 输出: 5
> 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
>      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

> 示例 2:

> 输入: [7,6,4,3,1]
> 输出: 0
> 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

> 1. 非空判断：prices长度必须 > 1
> 2. 确定状态：dp[i]表示在第i天卖出的最大利润
> 3. 转移方程：dp[i] = dp[i - 1] + prices[i] - prices[i - 1]
> 4. 边界：dp[0] = 0  dp[1] = 0;
> 5. 计算

```java
	public int maxProfit(int[] prices) {
         if(prices == null || prices.length <= 1){
            return 0;
        }
        //状态 dp[i]表示在第i天卖出的最大利润
        int dp[] = new int[prices.length + 1];
        //转移方程dp[i] = dp[i - 1] + prices[i] - prices[i - 1]
        int max = Integer.MIN_VALUE;
        //边界
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i <= prices.length;i ++){
            dp[i] = Math.max(dp[i - 1] + prices[i - 1] - prices[i - 2],0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
```

### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

> 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
>
> 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
>
> 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

> 示例 :
>
> 输入: [1,2,3,4,5]
> 输出: 4
> 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
>      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
>      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

solution 1

```java
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int sum = 0;
        for(int i = 1;i < len;i ++){
            sum += Math.max(0,prices[i] - prices[i - 1]);
        }
        return sum;
    }
```

solution 2

> 1. 非空判断：prices长度必须 > 1
>
> 2. 确定状态：dp[i]\[j]表示在第i天持有或者不持有的最大利润（持有或不持有就0 1来表示）
>
> 3. 转移方程：
>
>    ​				第i天持有：i-1天不持有，i天买入；i-1天持有，i天不卖出
>
>    ​				第i天不持有：i-1天不持有，i天不买入；i-1天持有，i天卖出
>
>    ​				dp[i]\[0] = max(dp[i-1]\[0],dp[i-1]\[1] + prices[i]);
>
>    ​				dp[i]\[1] = max(dp[i-1]\[1],dp[i-1]\[0] - prices[i]);
>
> 4. 边界：dp[0]\[0] = 0  dp[0]\[1] = -prices[0];
>
> 5. 计算

```java
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len + 1][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i <= len;i ++){
            //因为dp长度为len+1，最终返回dp[len]，所以是prices[i-1]
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i - 1]);

        }
        return dp[len][0];
    }
```



### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

> 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

> 示例 1:

> 输入: coins = [1, 2, 5], amount = 11
> 输出: 3 
> 解释: 11 = 5 + 5 + 1

> 示例 2:

> 输入: coins = [2], amount = 3
> 输出: -1
> 说明:
> 你可以认为每种硬币的数量是无限的。

> 1. 非空判断：coins最少有1个元素，amount必须 >= 0
> 2. 确定状态：dp[i]表示拼成i元所需最少硬币个数
> 3. 转移方程：dp[amount] = Math.min(dp[amount - conis[i]] + 1,dp[amount])
> 4. 边界：dp[0] = 0 
> 5. 计算

```java
    public int coinChange(int[] coins, int amount) {
        //非空判断
        if(coins == null || coins.length == 0 || amount < 0){
            return -1;
        }
        //确定状态；dp[i]表示拼成i元所需硬币个数
        int[] dp = new int [amount + 1];
        //状态方程
        //dp[amount] = Math.min(dp[amount - conis[i]] + 1,dp[amount])
        //边界        
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= amount;i ++){
            for(int j = 0;j < coins.length;j ++){
                //比如[1,2,5]凑出11，dp[i] = min(dp[i - 1],dp[i - 2],dp[i - 5])
                //保证不越界 && 保证 dp[i - j]存在，所以要加if判断
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i - coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount] ;
    }
```

### [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)

> 给定一个无序的整数数组，找到其中最长上升子序列的长度。

> 示例:

> 输入: [10,9,2,5,3,7,101,18]
> 输出: 4 
> 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

> 1. 非空判断：nums最少有一个元素
>
> 2. 确定状态：dp[i]表示前i个元素的最大上升子序列
>
> 3. 转移方程：包含nums[i]或者不包含nums[i]（必须以i结尾，因为dp[i]就是表示以i结尾的结果）
>
>    ​					nums[i] > nums[j]，dp[i] = dp[j] + 1；
>
>    ​					nums[i] < nums[j]，dp[i] = dp[i]			
>
> 4. 边界：dp[i] = 1
>
> 5. 计算

```java
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) 
            return 0;  
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i = 0;i < nums.length;i ++){
            for(int j = 0;j < i;j ++){
                //只有当nums[j] < num[i]时dp[i]=dp[j] + 1才成立，所以必须加个判断
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
```

### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

> 给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

**示例:**

```
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
```

![image.png](http://ww1.sinaimg.cn/large/007jDR55gy1gd8co2o2i7j30ii06t3yt.jpg)



> 1. 非空判断：height最少有三个元素
>
> 2. 确定状态：求出每个元素左边最高柱子和右边最高柱子
>
>    ​					max_left[i]表示i位置左边最高的柱子
>
>    ​					max_right[i]表示i位置右边最高的柱子
>
> 3. 转移方程：max_left[i] = Math.max(max_left[i - 1],height[i - 1])
>
>    ​					max_right[i] = Math.max(max_right[i + 1],height[i + 1])
>
> 4. 边界：最左边和最右边无法接雨水，所以不考虑
>
> 5. 计算

```java
	public int trap(int[] height) {
        if(height == null || height.length <=3){
            return 0;
        }
        int len = height.length;
        //max_left[i]表示i位置左边最高的柱子
        int[] max_left = new int[len];
        //max_right[i]表示i位置右边最高的柱子
        int[] max_right = new int[len];

        //边界
        for(int i = 1;i < len - 1;i ++){
            max_left[i] = Math.max(max_left[i - 1],height[i - 1]);
        }
        for(int i = len - 2;i > 0;i --){
            max_right[i] = Math.max(max_right[i + 1],height[i + 1]);
        }

        int sum = 0;
        int min = 0;
        for(int i = 1;i < len - 1;i ++){
            min = Math.min(max_left[i],max_right[i]);
            if(height[i] < min){
                sum += min - height[i];
            }
        }
        return sum;
    }
```

