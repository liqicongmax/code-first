package codeTop.回溯.子集类模板题.子集78;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2303 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        dfs(0,new ArrayList<>());
        return res;
    }


    // 数组nums中取n个数做全排列
    public void dfs(int index,List<Integer> tmp){
        if(index==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(index+1,tmp);

        tmp.add(nums[index]);
        dfs(index+1,tmp);
        tmp.remove(tmp.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
