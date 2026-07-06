import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, k;
    private static int[][] board;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }

    private static void solve() {
        for(int i = 0; i < k; i++) {

            while(explodeOnce()) {
                down();
            }
            
            rotate();
            down();
        }
        
        while(explodeOnce()) {
            down();
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != 0) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean explodeOnce() {
        boolean[][] toExplode = new boolean[n][n];
        
        for(int col = 0; col < n; col++) {
            int cnt = 1;
            
            for(int row = 0; row < n; row++) {
                if(row == 0) continue;
                
                if(board[row][col] != 0 && board[row][col] == board[row-1][col]) {
                    cnt++;
                } else {
                    if(cnt >= m && board[row-1][col] != 0) {
                        for(int r = row - cnt; r < row; r++) {
                            toExplode[r][col] = true;
                        }
                    }
                    cnt = 1;
                }
            }
            
            if(cnt >= m && board[n-1][col] != 0) {
                for(int r = n - cnt; r < n; r++) {
                    toExplode[r][col] = true;
                }
            }
        }
        
        boolean exploded = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(toExplode[i][j]) {
                    board[i][j] = 0;
                    exploded = true;
                }
            }
        }
        
        return exploded;
    }

    private static void down() {
        for(int col = 0; col < n; col++) {
            List<Integer> list = new ArrayList<>();
            
            for(int row = 0; row < n; row++) {
                if(board[row][col] != 0) {
                    list.add(board[row][col]);
                }
            }
            
            for(int row = 0; row < n; row++) {
                board[row][col] = 0;
            }
            
            int idx = n - list.size();
            for(int val : list) {
                board[idx++][col] = val;
            }
        }
    }

    private static void rotate() {
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = board[n - 1 - j][i];
            }
        }
        board = temp;
    }
}