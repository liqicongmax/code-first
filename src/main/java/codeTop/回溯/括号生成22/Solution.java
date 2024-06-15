package codeTop.回溯.括号生成22;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3601 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res=new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        dfs(0,0,new ArrayList<>());
        return res;
    }

    public boolean ok(int l, int r){
        return l>=r;
    }

    public void dfs(int l,int r,List<String> tmp){
        if(!ok(l,r)){
            return;
        }
        if(l>n||r>n){
            return;
        }
        if(l+r==n*2){
            res.add(String.join("",tmp));
            return;
        }
        // 放左括号
        tmp.add("(");
        dfs(l+1,r,tmp);
        tmp.remove(tmp.size()-1);

        tmp.add(")");
        dfs(l,r+1,tmp);
        tmp.remove(tmp.size()-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
