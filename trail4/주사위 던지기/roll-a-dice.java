import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, r, c;
    private static int[] directions;
    private static int[][] board;
    private static int[][] dice = {{0, 5, 0}, {4, 6, 3}, {0, 2, 0}};
    private static int[][] deltas = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        directions = new int[m];
        for(int i=0;i<m;i++) {
            String s = st.nextToken();
            if(s.equals("L")) directions[i]=0;
            else if(s.equals("R")) directions[i]=1;
            else if(s.equals("U")) directions[i]=2;
            else if(s.equals("D")) directions[i]=3;
        }
        board = new int[n+1][n+1];
        board[r][c] = dice[1][1];

        solve();
    }

    private static void solve() {
        roll();
        int ans = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                ans+= board[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void roll() {
        for(int i=0;i<m;i++) {
            int dir = directions[i];
            int nx = r+deltas[dir][0];
            int ny = c+deltas[dir][1];
            if(!inRange(nx, ny)) continue;

            int base = dice[1][1];
            if(dir==0) { // L
                dice[1][1] = dice[1][0];
                dice[1][0] = 7-base;
                dice[1][2] = base;
            } else if(dir==1) { // R
                dice[1][1] = dice[1][2];
                dice[1][0] = base;
                dice[1][2] = 7-base;
            } else if(dir==2) { // U
                dice[1][1] = dice[0][1];
                dice[2][1] = base;
                dice[0][1] = 7-base;
            } else { // D
                dice[1][1] = dice[2][1];
                dice[2][1] = 7-base;
                dice[0][1] = base;
            }

            board[nx][ny] = dice[1][1];
            r=nx;
            c=ny;
        }
    }
    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}


