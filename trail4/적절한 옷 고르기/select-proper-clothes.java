import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static Cloth[] clothes;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        clothes = new Cloth[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            clothes[i] = new Cloth(s, e, v);
        }

        dp = new int[m+1][n];
        for(int i=1;i<=m;i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int j=0;j<n;j++) {
            if(clothes[j].s > 1) continue;
            dp[1][j] = 0;
        }
        solve();
    }

    private static void solve() {
        for(int i=2;i<=m;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    Cloth c = clothes[k];
                    if(c.s > i || c.e < i) continue;
                    if(dp[i-1][j]==-1) continue;
                    dp[i][k] = Math.max(dp[i][k], dp[i-1][j]+calc(clothes[j].v, clothes[k].v));
                }
            }
        }

        int ans = 0;
        for(int i=0;i<=m;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(dp[i][j], ans);
            }
        }
        System.out.println(ans);
    }

    private static int calc(int a, int b) {
        return Math.abs(a-b);
    }

    static class Cloth {
        int s, e, v;

        public Cloth(int s, int e, int v) {
            this.s=s;
            this.e=e;
            this.v=v;
        }
    }
}