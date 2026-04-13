import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static int[][] board, result;
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;
    private static Queue<int[]> q = new ArrayDeque<>();

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void setResults() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (result[i][j]==-3) {
                    if(board[i][j]==1) {
                        result[i][j] = -2;
                    } else {
                        result[i][j] = -1;
                    }
                }
            }
        }
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int t = now[2];
            result[x][y] = t;

            for(int[] delta: deltas) {
                int nx = x+delta[0];
                int ny = y+delta[1];
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (board[nx][ny]==1) 
                    q.add(new int[]{nx, ny, t+1});
            }
        }    
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -3;

                if (board[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        bfs();
        setResults();
        print();
    }
}