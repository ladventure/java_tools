package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dylan.ll
 * @date 2022/1/16 15:31
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 数据限制显示，边很多，节点少，采用邻接矩阵加速一下试试
 */
public class Dijkstra_邻接矩阵_743_网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null || times.length == 0) {
            return -1;
        }
        //构造邻接矩阵
        int[][] ver=new int[n+1][n+1];

        for(int[] row:ver){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for (int i = 0; i < times.length; i++) {
            ver[times[i][0]][times[i][1]]=times[i][2];
        }

        //记录起始点到当前点的距离
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //无环可以不记录visited,记录了可以加速稍微，不用每次算距离
        boolean[] visited=new boolean[n+1];
        //无需path 可以不记录pre ver
        //int[] preV = new int[n + 1];

        //优先队列，用于每次取未访问过节点中的离起始点最近的节点
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        queue.add(new Pair(k,0));
        dis[k]=0;
        //visited[k]=true;
        while (!queue.isEmpty()){
            Pair curPair=queue.poll();
            //visited[k]=true;
            int curVer=curPair.key;
            int curDis=curPair.value;
            if(dis[curVer]<curDis){
                continue;
            }

            for (int i = 1; i < n+1; i++) {
                if(!visited[i] && ver[curVer][i]!=Integer.MAX_VALUE && dis[i]>dis[curVer]+ver[curVer][i]){
                    dis[i]=dis[curVer]+ver[curVer][i];
                    queue.add(new Pair(i,dis[i]));
                }
            }

        }

        int max=0;
        for (int i = 1; i < n+1; i++) {
            if(max<dis[i]){
                max=dis[i];
            }
        }
        if(max==Integer.MAX_VALUE){
            return -1;
        }
        return max;

    }


    class Pair implements Comparable<Pair> {

        /**
         * Key of this <code>Pair</code>.
         */
        public int key;


        /**
         * Value of this this <code>Pair</code>.
         */
        public int value;


        /**
         * Creates a new pair
         * @param key The key for this pair
         * @param value The value to use for this pair
         */
        public Pair( int key,  int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value-o.value==0){
                return this.key-o.key;
            }
            return this.value>o.value ? -1:1;
        }
    }

    public static void main(String[] args) {
        int[][] times={{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        int n=5,k=5;


        //int[][] times={{2,1,1},{2,3,1},{3,4,1}};
        //int n=4,k=2;
        System.out.println(new Dijkstra_邻接矩阵_743_网络延迟时间().networkDelayTime(times,n,k));
    }
}
