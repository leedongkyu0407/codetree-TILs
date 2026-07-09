import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board, copyBoard;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        copyBoard = new int[n][n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        solve();   
    }

    private static void solve() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                copy();
                explode(i, j);
                down();
                ans = Math.max(ans, count());
            }
        }
        System.out.println(ans);
    }

    private static int count() {
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(copyBoard[i][j]==0) continue;
                for(int[] delta: deltas) {
                    int nx = i+delta[0];
                    int ny = j+delta[1];
                    if(!inRange(nx, ny) || copyBoard[nx][ny]==0) continue;
                    if(copyBoard[i][j]==copyBoard[nx][ny]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt/2;
    }

    private static void copy() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
    }
    
    private static void down() {
        for(int i=0;i<n;i++) {
            List<Integer> al = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if(copyBoard[j][i]!=0) {
                    al.add(copyBoard[j][i]);            
                }
                copyBoard[j][i] = 0;
            } 

            int idx = n-1;
            for(int k=0;k<al.size();k++) {
                copyBoard[idx--][i] = al.get(al.size()-k-1); 
            }
        }
    }

    private static void explode(int a, int b) {
        int size = board[a][b];
        copyBoard[a][b]=0;

        for(int[] delta: deltas) {
            int x = a;
            int y = b;
            for(int i=1;i<size;i++) {
                int nx = x+delta[0];
                int ny = y+delta[1];
                if(!inRange(nx, ny)) continue;
                copyBoard[nx][ny] = 0;
                x=nx; 
                y=ny;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}