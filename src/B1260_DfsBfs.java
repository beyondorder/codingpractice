import java.io.*;
import java.util.*;

public class B1260_DfsBfs  {

    static int[][] map;
    static int N,M,V;

    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)  throws Exception{

        input();
        dfs(V);
        bw.newLine();
        Arrays.fill(visited,false);
        bfs(V);
        bw.flush();
    }

    static void dfs(int V) throws IOException {
        visited[V] = true;
        bw.write(String.valueOf(V));
        bw.write(" ");
        for(int i=1;i<=N;i++){
            if(map[V][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int V) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            bw.write(String.valueOf(now));
            bw.write(" ");
            for(int i=1;i<=N;i++){
                if(map[now][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }


    }

    public static void input()  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        Arrays.fill(visited,false);

        map = new int[N+1][N+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
    }

}
