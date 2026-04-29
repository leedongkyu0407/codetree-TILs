import java.io.*;
import java.util.*;

public class Main {
    
    static class SortedWork {
        int end, originalIdx;
        SortedWork(int end, int originalIdx) {
            this.end = end;
            this.originalIdx = originalIdx;
        }
    }
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, answer;
    private static int[][] albas;           
    private static SortedWork[] sorted;     
    private static int[] dp;

    private static void initialSetting() throws IOException {
        n = Integer.parseInt(bf.readLine());
        albas = new int[n][3];
        sorted = new SortedWork[n];
        dp = new int[n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            albas[i][0] = Integer.parseInt(st.nextToken());  // start
            albas[i][1] = Integer.parseInt(st.nextToken());  // end
            albas[i][2] = Integer.parseInt(st.nextToken());  // profit
            
            sorted[i] = new SortedWork(albas[i][1], i);  
        }
        

        Arrays.sort(sorted, (a, b) -> a.end - b.end);

        for(int i = 0; i < n; i++) {
            dp[i] = albas[i][2];
        }
        
        answer = 0;
    }

    private static void solve() {
        int maxDp = 0;
        int ptr = 0;
        

        for(int i = 0; i < n; i++) {

            while(ptr < n && sorted[ptr].end < albas[i][0]) {
                int origIdx = sorted[ptr].originalIdx;
                maxDp = Math.max(maxDp, dp[origIdx]);
                ptr++;
            }
            
            dp[i] = Math.max(dp[i], maxDp + albas[i][2]);
        }

        for(int i = 0; i < n; i++) {
            answer = Math.max(dp[i], answer);
        }
    }

    public static void main(String[] args) throws IOException {
        initialSetting();
        solve();
        System.out.println(answer);
    }
}