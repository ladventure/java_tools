package leetcode;

/**
 * @author dylan.ll
 * @date 2020/8/2 16:30
 */
public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        //构造一个图存储
        double[][] graph=getGraph(n,edges,succProb);

        //从start 到当前节点最大概率记录
        double[] maxSuccProbFromStart=new double[n];
        for(int i=0;i<n;i++){
            maxSuccProbFromStart[i]=0.0;
        }
        travelGraph(graph,start,1,maxSuccProbFromStart);
        return maxSuccProbFromStart[end];
    }

    //遍历图，传入图,当前节点，和当前的路径的成功率
    private void travelGraph(double[][] graph,int node,double countSuccProb,double[] maxSuccProbFromStart){
        if(countSuccProb <= maxSuccProbFromStart[node]){
            return;
        }
        maxSuccProbFromStart[node]=countSuccProb;
        for(int i=0;i<graph.length;i++){
            if(graph[node][i]>0 && countSuccProb*graph[node][i]>maxSuccProbFromStart[i]){
                travelGraph(graph,i,countSuccProb*graph[node][i],maxSuccProbFromStart);
            }
        }

    }
    private double[][] getGraph(int n, int[][] edges, double[] succProb){
        double[][] graph=new double[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                graph[i][j]=0.0;
            }
        }

        for(int i=0;i<edges.length;i++){
            int[] path=edges[i];
            graph[path[0]][path[1]]=succProb[i];
            graph[path[1]][path[0]]=succProb[i];
        }
        return graph;
    }

    public static void main(String[] args) {
        //int n=3;
        //int[][] edges={{0,1},{1,2},{0,2}};
        //double[] succProb={0.5,0.5,0.2};
        //int start=0;
        //int end=2;

        //int n=3;
        //int[][] edges={{0,1},{1,2},{0,2}};
        //double[] succProb={0.5,0.5,0.3};
        //int start=0;
        //int end=2;

        //int n=3;
        //int[][] edges={{0,1}};
        //double[] succProb={0.5};
        //int start=0;
        //int end=2;

        int n=5;
        int[][] edges={{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] succProb={0.37,0.17,0.93,0.23,0.39,0.04};
        int start=3;
        int end=4;
        System.out.println(new MaxProbability().maxProbability(n,edges,succProb,start,end));
    }
}
