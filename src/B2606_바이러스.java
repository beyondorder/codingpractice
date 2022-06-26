import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606_바이러스 {

    static int N,M;
    static int[][] map;
    static int answer=0;
    static boolean[] visited;

    public static void main(String[] args) {

        input();

        bfs(1);
        System.out.println(answer);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            for(int i=1;i<=N;i++){
                int node = map[now][i];
                if(!visited[i] && node==1){
                    visited[i] = true;
                    ++answer;
                    q.add(i);
                }
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        Arrays.fill(visited, false);

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }
    }

}
