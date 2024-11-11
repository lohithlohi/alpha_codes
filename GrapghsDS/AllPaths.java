package GrapghsDS;

import java.util.ArrayList;

public class AllPaths {
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
        graph[0].add(new Edge(0, 3, 1));
        
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

    // TC => O(V^V) !!!
    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            findAllPaths(graph, e.dest, dest, path+src);
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
         *           (2)    |    (1)
         *             \    |    ^
         *              V   V  /
         *                 (3)    
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        makeGraph(graph);
        int src = 5;
        int dest = 1;
        findAllPaths(graph, src, dest, "");

    }
}
