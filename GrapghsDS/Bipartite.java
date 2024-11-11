package GrapghsDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
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
        graph[0].add(new Edge(0, 4, 1));
        
        // vertices 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // vertices 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        // vertices 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));

        // vertices 4
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        // BFS Approach

        int colour[] = new int[graph.length];
        /*
         * colours--> (-1 = No colour), (0 = yellow), (1 = blue)
         */
        for (int i = 0; i < colour.length; i++) {
            colour[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(colour[i] == -1){
                // if(isBipartiteUtil(graph, i, colour)){
                //     return true;
                // }

                q.add(i);
                colour[i] = 0; // making yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                
                    for (int j = 0; j < graph[curr].size(); j++) {
                            Edge e = graph[curr].get(j);
                    
                        // case 3 -> Neighbour 'not coloured (-1)' -> colour with opposite and q.add
                        if (colour[e.dest] == -1) {
                            colour[e.dest] = (colour[curr] == 0)? 1: 0;
                            q.add(e.dest);
                        }
                        
                        // case 1 -> Neighbour is 'coloured' with 'same' colour as curr (parent)
                        else if (colour[e.dest] == colour[curr]) {
                            return false;  // NOT Bipartite condition
                        }
                        
                        // case 2 -> Neighbour is 'coloured' with 'Opposite' colour as curr (parent)
                        // DO Nothing  b/c valid condition of Bipartite
                    }
                }
            }
        }
        return true;
    }

    // public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int curr, int[] colour){
    //     // BFS Approach

    //     Queue<Integer> q = new LinkedList<>();

    //     q.add(0);
    //     while (!q.isEmpty()) {
    //         curr = q.remove();
    //         colour[curr] = 0; // making yellow

    //         for (int i = 0; i < graph[curr].size(); i++) {
    //             Edge e = graph[curr].get(i);

    //             // case 3 -> Neighbour 'not coloured (-1)' -> colour with opposite and q.add
    //             if (colour[e.dest] == -1) {
    //                 colour[e.dest] = (colour[curr] == 0)? 1: 0;
    //                 q.add(e.dest);
    //             }

    //             // case 1 -> Neighbour is 'coloured' with 'same' colour as curr (parent)
    //             else if (colour[e.dest] == colour[curr]) {
    //                 return false;  // NOT Bipartite condition
    //             }

    //             // case 2 -> Neighbour is 'coloured' with 'Opposite' colour as curr (parent)
    //             // DO Nothing  b/c valid condition of Bipartite
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        /*
         * if no cycle in graph --> Bipartite
         * if even cycle in graph --> Bipartite
         * if odd cycle in graph --> NOT Bipartite
         * 
         * Ex:  o/p - false
         * 
         *           0 --  4  
         *         /       |
         *        1        |
         *         \       |
         *           2 --  3
         * 
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        makeGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
