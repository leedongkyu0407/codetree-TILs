import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] dp, nums;

    public static void main(String[] args) throws IOException{
        initialSetting();
        System.out.println(solve());
    }

    private static void initialSetting() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static String solve() {
        for(int i=0;i<n;i++) {
            for(int j=m;j>=nums[i];j--) {
                if (dp[j-nums[i]] == -1) continue;
                dp[j] = 1;
            }
        }

        return dp[m]==1 ? "Yes" : "No";
    }
}