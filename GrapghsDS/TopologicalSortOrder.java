package GrapghsDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSortOrder {
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
        
        // vertices 1

        // vertices 2
        graph[2].add(new Edge(2, 3, 1));

        // vertices 3
        graph[3].add(new Edge(3, 1, 1));

        // vertices 4
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        // vertices 5
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    // ---------------------------------------------------------------------------
    //  DFS Approach
    // TC => O(V+E)   SC => O(V)  b/c Stack is used

    public static void topoSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topoSortUtil(graph, i, vis, stk);
            }
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop()+" ");
        }
    }
    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stk){
        // DFS Approach
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // normal DFS
            if(!vis[e.dest]){
                topoSortUtil(graph, e.dest, vis, stk);
            }
        }
        stk.push(curr);
    }

    // ---------------------------------------------------------------------

    // Khan's Algorithm BFS Approach

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            // i -> vertices
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topoSortKhan(ArrayList<Edge>[] graph){
        // find indegree of all nodes
        int[] indeg = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        // add all vertices in Q having indegree = 0   no incoming (Starting Node)
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS Approach
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");  // topological order printing

            // update indegree of Neighbours -> if it's Zero -> Q.add
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
         *
         * o/p -> 5 4 2 3 1 0
         * 
         *           (5)        (4)
         *           |  \      /  |
         *           |    V  V    |
         *           V     (0)    V
         *           (2)         (1)
         *             \         ^
         *              V      /
         *                 (3)    
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        makeGraph(graph);

        topoSort(graph);
        System.out.println();
        topoSortKhan(graph);

    }
}
