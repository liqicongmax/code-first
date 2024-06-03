package codeTop.二叉树.前序中序还原二叉树105;//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.TreeNode;

import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        if(n==0){
            return null;
        }
        int leftTreeSize=indexOf(inorder,preorder[0]);
        int[] pre1= Arrays.copyOfRange(preorder,1,1+leftTreeSize);
        int[] pre2=Arrays.copyOfRange(preorder, 1+leftTreeSize,n);
        int[] in1=Arrays.copyOfRange(inorder,0,leftTreeSize);
        int[] in2=Arrays.copyOfRange(inorder,leftTreeSize+1,n);

        TreeNode left=buildTree(pre1,in1);
        TreeNode right=buildTree(pre2,in2);

        return new TreeNode(preorder[0],left,right);
    }

    public int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
