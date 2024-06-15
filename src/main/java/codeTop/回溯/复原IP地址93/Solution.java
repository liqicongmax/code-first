package codeTop.回溯.复原IP地址93;//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1421 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String s;
    List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        for(int i=1;i<=3&&i<=s.length();i++) {
            dfs(0, i,new ArrayList<>());
        }
        return res;
    }

    public boolean isValidIpPart(String str){
        if(str.isEmpty() ||str.length()>3){
            return false;
        }
        if(str.length()>1&&str.startsWith("0")){
            return false;
        }
        int v = Integer.parseInt(str);
        return 0<=v&&v<=255;
    }

    public void dfs(int start,int end, List<String> tmp){
        String str=s.substring(start,end);
        if(!isValidIpPart(str)){
            return;
        }
        tmp.add(str);
        if(tmp.size()==4&&end==s.length()){
            res.add(String.join(".", tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        if(tmp.size()==3) {
            dfs(end, s.length(),tmp);
        }else{
            for(int i=1;i<=3&&end+i<=s.length();i++) {
                dfs(end, end+i,tmp);
            }
        }
        tmp.remove(tmp.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
