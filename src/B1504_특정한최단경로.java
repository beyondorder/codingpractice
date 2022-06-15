
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{

    int end;
    int weight;

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class B1504_특정한최단경로 {

    static int N, E, u, v;

    static boolean[] visited;
    static int[] dist;
    static final int INF = 200000000;
    static ArrayList<ArrayList<Node>> list;


    public static void main(String[] args) {
        input();

        int path1 = 0;
        path1 += dijkstra(1,u);
        path1 += dijkstra(u,v);
        path1 += dijkstra(v,N);

        int path2 = 0;
        path2 += dijkstra(1,v);
        path2 += dijkstra(v,u);
        path2 += dijkstra(u,N);

        int ans = (path1 >= INF && path2 >= INF) ? -1 : Math.min(path1, path2);
        System.out.println(ans);
    }

    static int dijkstra(int start, int end){

        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node : list.get(cur)){
                    if(!visited[node.end] && dist[node.end] > dist[cur]+node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i=1; i<=E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }
        u = sc.nextInt();
        v = sc.nextInt();
    }

}
