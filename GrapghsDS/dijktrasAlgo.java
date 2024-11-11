package GrapghsDS;

//  Dijktra's Algorithm - Single Node Shortest path
// BFS and PriorityQueue Approach :: TC => O(V + ElogV)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijktrasAlgo {
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        
        // vertices 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // vertices 2
        graph[2].add(new Edge(2, 4, 3));

        // vertices 3
        graph[3].add(new Edge(3, 5, 1));

        // vertices 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // vertices 5
    }

    static class Node implements Comparable<Node> {
        int ver;
        int dist;
        Node(int v){
            this.ver = v;
            this.dist = Integer.MAX_VALUE;  // +infinity
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;   // sorting based on distance to move in shortest path
        }
    }

    public static void dijktras(ArrayList<Edge>[] graph){
        // BFS Approach
        // initialize the all nodes dist to infinity
        Node node[] = new Node[graph.length];
        for (int i = 0; i < graph.length; i++) {
            node[i] = new Node(i);
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int startvert = 0;
        node[startvert].dist = 0;
        pq.add(node[startvert]);  // 0 -> src

        while (!pq.isEmpty()) {
            Node curr = pq.remove();
            if(!vis[curr.ver]){
                vis[curr.ver] = true;

                // update all Neighbour's distance of curr and pq.add()
                for (int i = 0; i < graph[curr.ver].size(); i++) {
                    Edge e = graph[curr.ver].get(i);
                    Node u = node[curr.ver];  // src
                    Node v = node[e.dest];  // dest

                    if(u.dist + e.wt < v.dist){
                        v.dist = u.dist + e.wt;
                        // pq.add(v);  // ??   (WORKS!!!)
                    }
                    node[e.dest] = v;
                    pq.add(node[e.dest]);
                } 
            }
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.println(startvert+" -> "+i+" : ("+node[i].dist+")");
        }
    }

    public static void main(String[] args) {
        /*
         *              7
         *           1 --> 3  
         *         ^ |     ^ \1
         *       2/  |     |  V
         *       0   |1   2|   5
         *       4\  |     |  ^
         *         v V     | /5
         *           2 --> 4
         *             3
         */

        // int[] arr = new int[7];  //syntax
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];

        makeGraph(graph);

        dijktras(graph);
    }
}
