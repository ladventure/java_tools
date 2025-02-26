package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor_236_二叉树的最近公共祖先 {
    /**
     * 进行两次查找，分别记录p和q的路径，然后从前往后比较路径，最先出现的不同的节点的上一个节点就是最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        dfs(root, p, pathP);
        dfs(root, q, pathQ);
        int res = Math.min(pathP.size(),pathQ.size())-1;
        for (int i = 0; i <= res; i++) {
            if (pathP.get(i).val != pathQ.get(i).val) {
                res= i-1;
                break;
            }
        }
        return pathP.get(res);
    }

    private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root==null) return false;
        path.add(root);
        if(root.val==target.val){
            return true;
        }
        if(dfs(root.left, target, path) || dfs(root.right, target, path)){
            return true;
        }
        // 如果不在该子树，回溯（删除路径中的当前节点）
        path.removeLast();
        return false;
    }

    @Test
    public void test(){
        TreeNode root=  TreeNode.convertTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p= new TreeNode(5);
        TreeNode q= new TreeNode(4);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
