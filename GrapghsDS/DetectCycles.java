package GrapghsDS;

import java.util.ArrayList;

public class DetectCycles {
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
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        
        // vertices 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // vertices 2
        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // vertices 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        // vertices 4
        graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean findCycles(ArrayList<Edge>[] graph){
        // DFS Approach
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(findCyclesUtil(graph, i, vis, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findCyclesUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, int parent){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 3 --> neighbour is 'not visited' and asking its network about cycles
            if(!vis[e.dest]){
                if (findCyclesUtil(graph, e.dest, vis, curr)) {
                    return true;
                }
            }

            // case 1 --> neighbour is 'visited' and checking if it's 'not parent'
            else if (vis[e.dest] && e.dest != parent) {
                return true;   // it's pakka cycle formation condition
            }

            // case 2 --> neighbour is 'visited' and checking if it's 'parent' --> "Do Nothing"
        }
        // traversed/ asked all neighbours but no cycles 'true' HIT
        return false;
    }

    public static void main(String[] args) {
        /*
         * 
         *           0 --  3  
         *         / |     |
         *        1  |     |
         *         \ |     |
         *           2     4
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        makeGraph(graph);

        System.out.println(findCycles(graph));

    }
}
