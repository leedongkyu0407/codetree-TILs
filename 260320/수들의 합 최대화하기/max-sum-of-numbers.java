import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board;
    private static boolean[] xVisited, yVisited; 
    private static int[] res;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        xVisited = new boolean[n];
        yVisited = new boolean[n];
        res = new int[n];
        perm(0);
        System.out.println(ans);
    }

    private static void perm(int depth) {
        if (depth == n) {
            int temp = 0;
            for(int i=0;i<res.length;i++) {
                temp += res[i];
            }
            ans = Math.max(ans, temp);
            return;
        }

        for(int i=0;i<n;i++) {
            if (xVisited[i]) continue;
            xVisited[i] = true;
            for(int j=0;j<n;j++) {
                if(yVisited[j]) continue;
                yVisited[j] = true;
                res[depth] = board[i][j];
                perm(depth+1);
                yVisited[j] = false;
                res[depth] = 0;
            }
            xVisited[i] = false;
        }
    }
}