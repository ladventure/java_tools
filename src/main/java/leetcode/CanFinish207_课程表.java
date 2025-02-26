package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 通过邻接矩阵或者邻接表存储 graph，然后 DFS 或者 BFS 、拓扑脾虚等查找是否有环
 */
public class CanFinish207_课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        拓扑排序，构造邻接表
        Set<Integer>[] graphTable = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphTable[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graphTable[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return !topologicalSort(graphTable,numCourses);


////        DFS
//        int[][] graph = new int[numCourses][numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
//        }
//        Set<Integer> visited = new HashSet<>();
//        Set<Integer> path = new HashSet<>();
//        for (int i = 0; i < numCourses ; i++) {
//            if (visited.contains(i)) {
//                continue;
//            }
//            if (dfs(graph, i, visited,path)) {
//               return false;
//            }
//        }
//        return true;

    }

//    拓扑排序找环，通过顶点的入度，所以拓扑排序更适合通过邻接表存储图
    private boolean topologicalSort(Set<Integer>[] graphTable, int numCourses) {
        Set<Integer> result = new HashSet<>();
        int[] inDegree=new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
//        计算每个节点入度，入度为0的节点入队列
        for (int i = 0; i < graphTable.length; i++) {
            graphTable[i].forEach(n->inDegree[n]++);
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
           int node= queue.poll();
           result.add(node);
           graphTable[node].forEach(n->{
               inDegree[n]-=1;
               if (inDegree[n]==0){
                   queue.add(n);
               }
           });
        }
        if (result.size()==numCourses){
            return false;
        }
        return true;
    }

//    dfs 找环，对于有向图，需要一个数组，记录当前的访问路径，通过访问路径上是否存在节点判断是否成环
    private boolean dfs(int[][] graph, int start, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(start)) {
            return true;
        }
//        剪枝，已经访问过的节点，不需要再访问
        if (visited.contains(start)) {
            return false;
        }
        visited.add(start);
        path.add(start);
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] == 1) {
                if(dfs(graph, i, visited,path)) {
                    return true;
                }
            }
        }
        path.remove(start);
        return false;
    }

    @Test
    public void test(){
        System.out.println(canFinish(2,new int[][]{{1,0}}));

    }
}
