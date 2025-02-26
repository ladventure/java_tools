package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author dylan.ll
 * @date 2020/7/12 18:41
 */
public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        List<Node> list=new ArrayList<Node>();
        if(nums==null){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            Node node=new Node(nums[i],i);
            list.add(node);
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value-o2.value;
            }
        });

        int pairNum=0;
        int count=1;
        for (int i = 1; i <list.size() ; i++) {
            if(Objects.equals(list.get(i).value,list.get(i-1).value)){
                count++;
            }else {
                pairNum=pairNum+(count*(count-1))/2;
                count=1;
            }
        }
        pairNum=pairNum+(count*(count-1))/2;
return pairNum;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,3};
        System.out.println(new NumIdenticalPairs().numIdenticalPairs(nums));
    }
}
class Node{
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
