import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//메모리초과됬음... 문제는 풀림

class Combi implements Comparable<Combi>{
    int first;
    int second;
    int abs_sum;

    Combi(int first, int second){
        this.first = first;
        this.second = second;
        this.abs_sum = Math.abs(first + second);
    }

    @Override
    public int compareTo(Combi o) {
        return this.abs_sum - o.abs_sum;
    }
}

public class B2470_두용액 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();

        List<Combi> list = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                list.add(new Combi(arr[i],arr[j]));
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0).first);
        System.out.println(list.get(0).second);
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }
}
