package codeTop.二叉树.平衡二叉树110;//给定一个二叉树，判断它是否是 平衡二叉树
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1517 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxWidth(root)==-1;
    }


    public int maxWidth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = maxWidth(root.left);
        if(l==-1){
            return -1;
        }
        int r = maxWidth(root.right);
        if(r==-1){
            return -1;
        }
        return Math.abs(l-r)<2?Math.max(maxWidth(root.left),maxWidth(root.right))+1:-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
