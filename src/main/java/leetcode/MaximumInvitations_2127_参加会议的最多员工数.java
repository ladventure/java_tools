package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumInvitations_2127_参加会议的最多员工数 {

    /**
    题目： https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/
     题解：安排最大的环，或者安排所有两个节点的环以及环关联的链节点，看两者哪个大
     通过拓扑排序，找出所有的环，然后统计最大的环；通过动态规划计算两个节点环上的关联路径长度
     */
    public int maximumInvitations(int[] favorite) {

        //    拓扑排序，找出所有的环; 并且拓扑排序的时候动态规划记录每个节点的最长路径
        int[] inDegree = new int[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            inDegree[favorite[i]]++;
        }
//        记录节点的最长路径
        int[] pathLen = new int[favorite.length];
        Arrays.fill(pathLen,1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
       while (!queue.isEmpty()){
           int cur=queue.poll();
           inDegree[favorite[cur]]--;
           pathLen[favorite[cur]]=Math.max(pathLen[favorite[cur]],pathLen[cur]+1);
           if (inDegree[favorite[cur]]==0){
               queue.add(favorite[cur]);
           }
       }

//       检查环以及计算2节点环的最大路径之和
       int maxRing=0;
       int total2NodePathLen=0;
       for (int i = 0; i < inDegree.length; i++) {
           if (inDegree[i]==0){
               continue;
           }
//           2 节点环
           if (favorite[favorite[i]]==i){
               int cur2NodePathLen=pathLen[i]+pathLen[favorite[i]];
               total2NodePathLen+=cur2NodePathLen;
//               把环上的节点置为0，避免重复计算
               inDegree[favorite[i]]=0;
           }else {
               int curRing=1;
               int cur=i;
               while (favorite[cur]!=i){
                   inDegree[cur]=0;
                   cur=favorite[cur];
                   curRing++;
               }
               maxRing=Math.max(maxRing,curRing);
           }

       }
       return Math.max(maxRing,total2NodePathLen);
    }

    @Test
    public void test(){
        int[] nums=new int[]{2,2,1,2};
        System.out.println( maximumInvitations(nums));
        int[] nums2=new int[]{1,2,0};
        System.out.println( maximumInvitations(nums2));
        int[] nums3=new int[]{3,0,1,4,1};
        System.out.println( maximumInvitations(nums3));
    }
}
