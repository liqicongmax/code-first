package codeTop.回溯.全排列II;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1575 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        dfs(new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void dfs(boolean[] vis,List<Integer> tmp){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // 因为数组是排序后的，在这轮遍历中，是给同级选值，所以如果这个值和上一个一样，就跳过
            // 因为同级对于重复数据，只会使用从左往右的第一个，且因为标记结果会回滚，vis记录在同级遍历的时候，每个vis[x]都是false，那么可以认为nums[i]==nums[i-1]&&vis[i-1]=false的时候，这是同级且当前位置已经被使用过了，即跳过当前index
            if(vis[i]||(i>0&&nums[i]==nums[i-1]&&!vis[i-1])){
                continue;
            }
            tmp.add(nums[i]);
            vis[i]=true;
            dfs(vis,tmp);
            vis[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
