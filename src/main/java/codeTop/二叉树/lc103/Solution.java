package codeTop.二叉树.lc103;
//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 893 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.TreeNode;

import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int len=1;
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tempList = new ArrayList<>();
        int nextSize=0;
        boolean reverse=true;
        while (!queue.isEmpty()){
            TreeNode node =queue.poll();
            len--;
            tempList.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                nextSize++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextSize++;
            }
            if(len==0){
                if(reverse) {
                    Collections.reverse(tempList);
                    res.add(new ArrayList<>(tempList));
                }
                tempList.clear();
                reverse=!reverse;
                len=nextSize;
                nextSize=0;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
