package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

public class MaxPathSum_124_二叉树中的最大路径和 {
    Integer maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxSum;
    }

    /**
     * 思路：分析可知，经过当前节点的最大路径和等于 max(左子树最大路径和+当前节点值,当前节点值+右子树最大路径和,当前节点值,左子树最大路径和+当前节点值+右子树最大路径和)
     * 但是上一个节点的最大节点的最大路径和的时候，是不能同时走左右子树的，
     * 所以递归返回的是只走左右子树一个的最大路径和，递归过程中，通过一个全局变量去记录全局最大路径和
     * @param root
     * @return
     */
    private int getMaxSum(TreeNode root) {
        if (root == null) return 0;
        int sum=Integer.MIN_VALUE;
        int leftSum=0,rightSum=0;
        if (root.left != null) {
            leftSum = getMaxSum(root.left);
        }
        if (root.right != null) {
            rightSum = getMaxSum(root.right);
        }
        sum = Math.max(leftSum+root.val,Math.max(rightSum+root.val,root.val));

        maxSum=Math.max(maxSum,Math.max(rightSum+root.val+leftSum,sum));
        return sum;
    }

    @Test
    public void test(){
        TreeNode root=  TreeNode.convertTreeNode(new Integer[]{1,2,3});
        System.out.println(new MaxPathSum_124_二叉树中的最大路径和().maxPathSum(root));
        TreeNode root2=  TreeNode.convertTreeNode(new Integer[]{-10,9,20,null,null,15,7});
        System.out.println(new MaxPathSum_124_二叉树中的最大路径和().maxPathSum(root2));

        TreeNode root3=  TreeNode.convertTreeNode(new Integer[]{0,1,1});
        System.out.println(new MaxPathSum_124_二叉树中的最大路径和().maxPathSum(root3));
    }
}
