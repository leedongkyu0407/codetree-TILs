import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[][] arr, prefixSum;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefixSum = new int[n+1][n+1];
        makePrefixSum();
        System.out.println(solve());
    }

    private static void makePrefixSum() {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                prefixSum[i][j] = prefixSum[i-1][j]+prefixSum[i][j-1]-prefixSum[i-1][j-1]+arr[i][j];
            }
        }
    }

    private static int solve() {
        int ans = 0;
        for(int i=k;i<=n;i++) {
            for(int j=k;j<=n;j++) {
                int rangeOver = prefixSum[i][j]-prefixSum[i-k][j]-prefixSum[i][j-k]+prefixSum[i-k][j-k];
                ans = Math.max(ans, rangeOver);
            }
        }
        return ans;
    }
}