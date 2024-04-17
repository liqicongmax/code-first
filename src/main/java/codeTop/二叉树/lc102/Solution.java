package codeTop.二叉树.lc102;//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1944 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int curSize=1;
        int nextSize=0;
        List<Integer> tmp=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            tmp.add(node.val);
            curSize--;
            if(node.left!=null){
                queue.offer(node.left);
                nextSize++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextSize++;
            }
            if(curSize==0){
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                curSize=nextSize;
                nextSize=0;
            }
        }
        return res;
    }

    //dfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res= new ArrayList<>();
        dfs(1,root,res);
        return res;
    }

    public void dfs(int level,TreeNode root,List<List<Integer>> res){
        if(level>res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level-1).add(root.val);
        if(root.left!=null){
            dfs(level+1,root.left,res);
        }
        if(root.right!=null){
            dfs(level+1,root.right,res);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
