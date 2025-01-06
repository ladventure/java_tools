package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dylan.ll
 * @date 2020/11/1 16:40
 * 单源最短路径算法，Dijkstra 算法，求单源最短路径，即单点到其他点的最短路径
 * 思想：通过遍历边，加入顶点，更新最短路径确定算法。
 */

public class Dijkstra_最短路径_MaxProbability_1514 {


    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Pair>> graphMap=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            graphMap.add(i,new ArrayList<Pair>());
        }

        // init graph，冗余存储 边，方便遍历
        for (int i = 0; i <edges.length ; i++) {

            graphMap.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            graphMap.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }

        //存储start 到各个节点的最大pro
        double[] maxPath=new double[n];


        //maxPath 的优先队列存储，方便遍历取出优先队列
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        //初始化,放入start 和相应的 pro=1，
        maxPath[start]=1;
        queue.add(new Pair(start,1.0));

        //遍历其他节点
        while (!queue.isEmpty()){
            Pair tmp=queue.poll();
            int index=tmp.getKey();
            double pro=tmp.getValue();

            //如果相同，则表示这个节点已经访问过了，则跳过，用于跳过已经visit 的节点
            if(maxPath[index] > pro ){
                continue;
            }

            //找到最大的节点，然后遍历这个节点对应的边，更新相连节点的pro，并把节点接入queue
            for (Pair one: graphMap.get(index)) {
                int nextIndex=one.getKey();
                double nextPro=one.getValue();
                if(maxPath[nextIndex]<maxPath[index]*nextPro){
                    maxPath[nextIndex]=maxPath[index]*nextPro;
                    queue.offer(new Pair(nextIndex,maxPath[nextIndex]));
                }
            }

        }



        return maxPath[end];

    }

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0, end = 2;
        System.out.println(new Dijkstra_最短路径_MaxProbability_1514().maxProbability(n,edges,succProb,start,end));


    }
}

class Pair implements Comparable<Pair> {

    /**
     * Key of this <code>Pair</code>.
     */
    private int key;

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public int getKey() { return key; }

    /**
     * Value of this this <code>Pair</code>.
     */
    private double value;

    /**
     * Gets the value for this pair.
     * @return value for this pair
     */
    public double getValue() { return value; }

    /**
     * Creates a new pair
     * @param key The key for this pair
     * @param value The value to use for this pair
     */
    public Pair( int key,  double value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.getValue()-o.getValue()==0){
            return this.getKey()-o.getKey();
        }
        return this.getValue()>o.getValue() ? -1:1;
    }
}

