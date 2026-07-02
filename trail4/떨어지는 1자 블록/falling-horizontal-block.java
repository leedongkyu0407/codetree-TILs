import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, k;
    private static int[][] board;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    private static int findX(int startY, int endY) {
        int x = Integer.MAX_VALUE;
        for(int i=startY;i<=endY;i++) {
            for(int j=1;j<=n;j++) {
                if (board[j][i]!=0) {
                    x = Math.min(x, j);
                }
            }
        }
        
        if (x==Integer.MAX_VALUE) return n;
        return --x;
    }

    private static void solve() {
        int startY = k, endY = k+m-1;

        int x = findX(startY, endY);
        for(int i=startY;i<=endY;i++) {
            board[x][i] = 1;
        }
        printAns();
    }

    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}