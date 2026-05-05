import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] nums, dp;

    private static void initialSetting() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n+1];
        dp = new int[m+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 10001);
        dp[0] = 0;
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=m;j>=nums[i];j--) {
                if(dp[j-nums[i]]==10001) continue;
                dp[j] = Math.min(dp[j], dp[j-nums[i]]+1);
            }
        }
        return dp[m]==10001 ? -1 : dp[m];
    }
    
    public static void main(String[] args) throws IOException{
        initialSetting();
        System.out.println(solve());
    }
}