import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] board;
    private static int[][] deltas = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    private static Map<Integer, int[]> hm = new HashMap<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                hm.put(board[i][j], new int[]{i, j});
            }
        }
        solve();
    }

    private static void solve() {
        for(int i=0;i<m;i++) {
            for(int j=1;j<=n*n;j++) {
                int[] now = hm.get(j);
                int tmp = 0;
                int newX = 0;
                int newY = 0;

                for(int[] delta: deltas) {
                    int nx = now[0]+delta[0];
                    int ny = now[1]+delta[1];
                    if(!inRange(nx, ny)) continue;
                    if(tmp < board[nx][ny]) {
                        newX = nx;
                        newY = ny;
                        tmp = board[nx][ny];
                    }
                }
                board[now[0]][now[1]] = tmp;
                board[newX][newY] = j;
                hm.put(j, new int[]{newX, newY});
                hm.put(tmp, now);  
            }
        }
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}