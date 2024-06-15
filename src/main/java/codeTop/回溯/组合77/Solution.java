package codeTop.回溯.组合77;//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1633 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        dfs(1,new ArrayList<>());
        return res;
    }

    public void dfs(int i,List<Integer> tmp){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(;i<=n;i++){
            tmp.add(i);
            dfs(i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public void dfs1(int i,List<Integer> tmp){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(n-i+1<k){
            return;
        }
        if(i>n){
            return;
        }
        dfs1(i+1,tmp);

        tmp.add(i);
        dfs1(i+1,tmp);
        tmp.remove(tmp.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
