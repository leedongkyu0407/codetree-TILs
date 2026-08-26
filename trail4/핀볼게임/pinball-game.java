import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board;
    // 우하좌상
    private static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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
        solve();
        System.out.println(ans);
    }

    private static void solve() {
        for(int i=0;i<n;i++) {
            ans = Math.max(ans, simulate(i, -1, 0)); 
            ans = Math.max(ans, simulate(-1, i, 1));   
            ans = Math.max(ans, simulate(i, n, 2));
            ans = Math.max(ans, simulate(n, i, 3));
        }
    }

    private static int simulate(int x, int y, int dir) {
        int t = 0;

        while(true) {
            int nx = x+deltas[dir][0];
            int ny = y+deltas[dir][1];
            t++;
            
            if(!inRange(nx, ny)) return t;

            if(board[nx][ny]==1) {
                dir = reverseSlash(dir);
            } else if (board[nx][ny]==2) {
                dir = slash(dir);
            }

            x = nx;
            y = ny;
        }
    } 

    private static int slash(int dir) {
        switch(dir) {
            case 0: return 1;
            case 1: return 0;
            case 2: return 3;
            case 3: return 2;
        }

        return dir;
    }

    private static int reverseSlash(int dir) {
        switch(dir) {
            case 0: return 3;
            case 1: return 2;
            case 2: return 1;
            case 3: return 0;
        }
        return dir;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

}