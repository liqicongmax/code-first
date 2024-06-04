package codeTop.二叉树.lcr143;//给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。 注意，空树 不会是以
//tree1 的某个节点为根的子树具有 相同的结构和节点值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//
// 
//输入：tree1 = [1,7,5], tree2 = [6,1]
//输出：false
//解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
//输出：true
//解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。 
//
// 
//
// 提示： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 813 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B ==null){
            return false;
        }
        return dfs(A,B);
    }

    public boolean dfs(TreeNode a,TreeNode b){
        if(a==null||b==null){
            return false;
        }
        boolean f=false;
        if(a.val==b.val){
            f=isSame(a,b);
        }
        return f||dfs(a.left,b)||dfs(a.right,b);
    }

    public boolean isSame(TreeNode a,TreeNode b){
        if(a==null||b==null){
            return false;
        }
        boolean left=true;
        if(b.left!=null){
            left = isSame(a.left,b.left);
        }
        boolean right=true;
        if(b.right!=null){
            right=isSame(a.right,b.right);
        }
        return a.val==b.val&&left&&right;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
