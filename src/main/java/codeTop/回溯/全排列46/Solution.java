package codeTop.回溯.全排列46;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2902 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, List<Integer> tmp){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int num : nums) {
            if (tmp.contains(num)) {
                continue;
            }
            tmp.add(num);
            dfs(nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
