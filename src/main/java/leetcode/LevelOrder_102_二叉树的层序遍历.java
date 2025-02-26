package leetcode;


import leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root,0,res);
        return res;
    }

    private void bfs(TreeNode root, int level,List<List<Integer>> res) {
        if(root==null) return;
        if(res.size()==level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        bfs(root.left,level+1,res);
        bfs(root.right,level+1,res);
    }

    @Test
    public  void test(){
        TreeNode root=  TreeNode.convertTreeNode(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(levelOrder(root));
    }
}

