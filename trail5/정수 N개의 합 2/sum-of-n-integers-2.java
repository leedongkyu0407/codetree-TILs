import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] nums;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }        

        int[] prefixSum = new int[n+1];

        for(int i=1;i<=n;i++) {
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }

        int ans = Integer.MIN_VALUE;
        for(int i=k;i<=n;i++) {
            ans = Math.max(ans, prefixSum[i]-prefixSum[i-k]);
        }

        System.out.println(ans);
    }
}