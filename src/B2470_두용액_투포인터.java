import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B2470_두용액_투포인터 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int point = Integer.MAX_VALUE;

        int sum;
        int temp;

        int ans1=0, ans2=0;
        while (left<right){
            sum = arr[left]+arr[right];
            temp = Math.abs(sum);
            if(temp < point){
                point = temp;
                ans1=arr[left];
                ans2=arr[right];
            }
            if(sum > 0)
                right--;
            else
                left++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans1).append(" ").append(ans2);
        System.out.print(sb);

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
