import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] board;
    private static int[] bombs;
    private static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<m;i++) {
            int r = Integer.parseInt(bf.readLine());
            explode(r);
            down();
        }
        printRes();
    }

    private static void printRes() {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void explode(int row) {
        int start = 0;
        int bombSize = 0;
        for(int i=1;i<=n;i++) {
            if(board[i][row]!=0) {
                start = i;
                bombSize = board[start][row];
                break;
            }
        }

        if(start==0 || bombSize==0) return;

        for(int[] delta : deltas) {
            board[start][row] = 0;
            for(int i=1;i<bombSize;i++) {
                int nx = start+(delta[0]*i);
                int ny = row+(delta[1]*i);
                if (!inRange(nx, ny)) break;
                board[nx][ny] = 0;
            }
        }
    }

    private static void down() {
        int[][] temp = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            List<Integer> ls = new ArrayList<>();
            for(int j=1;j<=n;j++) {
                if(board[j][i]!=0){
                    ls.add(board[j][i]);
                }
            }

            int idx = n;
            for(int k=ls.size();k>0;k--) {
                temp[idx--][i] = ls.get(k-1);
            }
        }
        board = temp;
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}