import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums, dp;

    private static void initialSetting() throws IOException {
        n = Integer.parseInt(bf.readLine());   
        dp = new int[n+1];
        nums = new int[4];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 5;
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=3;j++) {
                if(i-nums[j] < 0) continue;
                dp[i] = ((dp[i]+dp[i-nums[j]])%10007);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException{
        initialSetting();
        System.out.println(solve());
    }
}