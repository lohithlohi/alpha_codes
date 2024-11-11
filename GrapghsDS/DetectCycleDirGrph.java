package GrapghsDS;

import java.util.ArrayList;

public class DetectCycleDirGrph {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Array of ArrayList of Edge
    public static void makeGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertices 0
        graph[0].add(new Edge(0, 2, 1));
        // graph[0].add(new Edge(0, 3, 1));
        
        // vertices 1
        graph[1].add(new Edge(1, 0, 1));

        // vertices 2
        graph[2].add(new Edge(2, 3, 1));

        // vertices 3
        graph[3].add(new Edge(3, 0, 1));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];  // to track call stack path

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){
        // DFS Approach
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1 -> (Present Path) has call-stack[neighbour] == true  => cycle condition
            if(stack[e.dest] == true){
                return true;
            }

            // case 2 -> Normal DFS operation
            else if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;  // erasing path of current call stack
        return false;
    }

    public static void main(String[] args) {
        /*
         * 
         * 
         * Ex:  o/p - true
         * 
         *      1 -->  0  <
         *            |    \ 
         *            V     \
         *            2 -->  3
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[4];

        makeGraph(graph);

        System.out.println(isCycle(graph));
    }
}
