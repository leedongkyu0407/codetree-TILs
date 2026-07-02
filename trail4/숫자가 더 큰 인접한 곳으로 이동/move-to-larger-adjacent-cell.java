import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, r, c;
    private static int[][] board;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        int nowX = r, nowY = c;

        while(true) {
            boolean flag = false;
            sb.append(board[nowX][nowY]).append(" ");

            for(int[] delta: deltas) {
                int nx = nowX+delta[0];
                int ny = nowY+delta[1];
                if(!inRange(nx, ny)) continue;
                if(board[nx][ny] > board[nowX][nowY]) {
                    nowX = nx;
                    nowY = ny;
                    flag = true;
                    break;
                }
            }

            if (!flag) return;
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}