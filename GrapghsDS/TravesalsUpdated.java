package GrapghsDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TravesalsUpdated {
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
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        
        // vertices 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // vertices 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // vertices 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // vertices 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertices 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // vertices 6
        graph[6].add(new Edge(6, 5, 1));
    }

    // TC => O(V+E)
    //  this function is to tackle all components of the graph
    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, i, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        while (!q.isEmpty()) {
            curr = q.remove();

            if(!vis[curr]){    // should not visited
                vis[curr] = true;
                System.out.print(curr+" ");
                
                // add curr's neighbours into queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // TC => O(V+E)
    //  this function is to tackle all components of the graph
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        // 1. visit and print curr
        System.out.print(curr+" ");
        vis[curr] = true;

        // 2. add curr's neighbour one by one after checking visit status each
        //   call for Neighbours who are not visited
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){  // should not be visited
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        /*
         * 
         *           1 --  3  
         *         /       |  \
         *        0        |   5 -- 6
         *         \       |  /
         *           2 --  4
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[7];

        makeGraph(graph);

        System.out.print("BFS: ");
        bfs(graph);
        
        System.out.print("\nDFS: ");
        dfs(graph);  // recursive way
    }
}
