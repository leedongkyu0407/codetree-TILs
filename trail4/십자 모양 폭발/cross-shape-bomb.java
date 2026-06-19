import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, r, c;
    private static int[][] board, answer;
    private static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n+1][n+1];
        answer = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        solve();
    }

    private static void solve() {
        int amount = board[r][c];
        board[r][c] = 0;
        for(int i=0;i<4;i++) {
            int nowX = r;
            int nowY = c;
            for(int j=1;j<amount;j++) {
                int nx = nowX+deltas[i][0];
                int ny = nowY+deltas[i][1];
                if (!inRange(nx, ny)) continue;
                board[nx][ny] = 0;
                nowX = nx;
                nowY = ny;
            }
        }
        move();
        print();
    }

    private static void move() {
        
        for(int i=1;i<=n;i++) {
            int[] temp = new int[n+1];
            int idx = n;
            for(int j=1;j<=n;j++) {
                if(board[j][i]!=0) {
                    temp[idx--] = board[j][i];
                }
            }    

            idx = n;
            for(int k=1;k<=n;k++) {
                if(temp[k]!=0) {
                    answer[idx--][i] = temp[k];
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}