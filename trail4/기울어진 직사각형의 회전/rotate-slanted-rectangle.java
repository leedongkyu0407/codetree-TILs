import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, r, c, dir, nowX, nowY;
    private static int[] m;
    private static int[][] board, answer;
    private static int[][] deltas = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    private static void setting() throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n+1][n+1];
        answer = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j] = board[i][j];
            }
        }
        m = new int[4];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m[0] = Integer.parseInt(st.nextToken());
        m[1] = Integer.parseInt(st.nextToken());
        m[2] = Integer.parseInt(st.nextToken());
        m[3] = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        nowX = r;
        nowY = c;
    }

    private static void solve() {
        if(dir==1) {
            for(int i=3;i>=0;i--) {
                move(m[i], dir);
                if(dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            }
        }
        else {
            for(int i=0;i<4;i++) {
                move(m[i], dir++);
            }
        }
    }

    private static void move(int m, int d) {    
        int[] delta = deltas[d];
        for(int i=0;i<m;i++) {
            int nx = nowX+delta[0];
            int ny = nowY+delta[1];
            answer[nx][ny] = board[nowX][nowY];
            nowX = nx;
            nowY = ny;
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

    public static void main(String[] args) throws IOException{
        setting();
        solve();
        print();
    }
}