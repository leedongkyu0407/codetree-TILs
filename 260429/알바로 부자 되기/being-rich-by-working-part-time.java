import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, answer;
    private static int[][] albas;
    private static int[] dp;

    private static void initialSetting() throws IOException{
        n = Integer.parseInt(bf.readLine());
        albas = new int[n][3];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<3;j++) {
                albas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(albas, (a, b) -> {
            if(a[1] != b[1])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        dp = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = albas[i][2];
        }
        answer = 0;
    }

    private static void solve() {
        int maxDp = 0;
        int ptr = 0;

        for(int i=0;i<n;i++) {
            while(ptr < i && albas[ptr][1] < albas[i][0]) {
                maxDp = Math.max(maxDp, dp[ptr]);
                ptr++;
            }

            dp[i] = Math.max(dp[i], maxDp+albas[i][2]);
        }

        for(int i=0;i<n;i++) {
            answer = Math.max(dp[i], answer);
        }
    }

    public static void main(String[] args) throws IOException{
        initialSetting();
        solve();
        System.out.println(answer);
    }
}