import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178_미로탐색 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = new int[]{1,-1,0,0};
    static int[] dirY = new int[]{0,0,1,-1};

    public static void main(String[] args) {

        input();

        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++){
                int newX = nowX + dirX[i];
                int newY = nowY + dirY[i];
                if(newX < 0 || newX >= N || newY < 0 || newY >= M ) continue;
                if(visited[newX][newY] ||  map[newX][newY] == 0) continue;

                visited[newX][newY] = true;
                map[newX][newY] = map[nowX][nowY] + 1;
                q.add(new int[]{newX,newY});
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M=  sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i],false);
        }

        for(int i=0;i<N;i++){
            String str = sc.next();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

}
