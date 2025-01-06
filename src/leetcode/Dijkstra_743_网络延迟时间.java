package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dylan.ll
 * @date 2022/1/16 15:31
 */
public class Dijkstra_743_网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null || times.length == 0) {
            return -1;
        }
        //构造邻接表, Pair： key 表示节点，value 表示到节点的距离
        List<Pair>[] verEdges=new List[n+1];
        for (int i = 0; i < n+1; i++) {
            verEdges[i]=new ArrayList<>();
        }
        for (int i = 0; i < times.length; i++) {
            verEdges[times[i][0]].add(new Pair(times[i][1],times[i][2]));
        }

        //记录起始点到当前点的距离
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        //无环可以不记录visited
        //boolean[] visited=new boolean[n+1];
        //无需path 可以不记录pre ver
        //int[] preV = new int[n + 1];

        //优先队列，用于每次取未访问过节点中的离起始点最近的节点
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        queue.add(new Pair(k,0));
        dis[k]=0;

        while (!queue.isEmpty()){
            Pair curPair=queue.poll();
            int curVer=curPair.key;
            int curDis=curPair.value;
            if(dis[curVer]<curDis){
                continue;
            }

            for(Pair next:verEdges[curVer]){
                int nextVer=next.key;
                int nextNewDis=dis[curVer]+next.value;
                if(nextNewDis<dis[nextVer]){
                    dis[nextVer]=nextNewDis;
                    queue.add(new Pair(next.key,nextNewDis));
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
        System.out.println(new Dijkstra_743_网络延迟时间().networkDelayTime(times,n,k));
    }
}
