import java.util.*;
import java.io.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[] maxJump;
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        maxJump = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            maxJump[i] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MAX_VALUE;
        perm(0, 0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    private static void perm(int pos, int cnt) {
        if (pos == n-1) {
            ans = Math.min(ans, cnt);
            return;
        }

        for(int i=1;i<=maxJump[pos];i++) {
            if (pos > n-1) continue;
            perm(pos+i, cnt+1);
        }
    }
}