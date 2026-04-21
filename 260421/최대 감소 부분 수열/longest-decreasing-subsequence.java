import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums, dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if (nums[i] >= nums[j]) continue;
                dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            ans =Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}