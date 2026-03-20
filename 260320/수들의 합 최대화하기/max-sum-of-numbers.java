import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board;
    private static boolean[] visited; 

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
        visited = new boolean[n];
        perm(0, 0);
        System.out.println(ans);
    }

    private static void perm(int row, int sum) {
        if (row == n) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0;i<n;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(row+1, sum+board[row][i]);
            visited[i] = false;
        }
    }
}