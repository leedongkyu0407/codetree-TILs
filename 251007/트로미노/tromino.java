import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans;
    static int[][] board;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] deltas = {{-1, 0}, {0, 1}, {0, 1}, {1, 0}, {1, 0}, {0, -1}, {0, -1}, {-1, 0}};
    static int[][] deltas2 = {{0, 1}, {0, 2}, {1, 0}, {2, 0}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }
        check1();
        check2();
        System.out.println(ans);
    }

    private static void check1() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                for (int k=0;k<4;k++) {
                    int temp = board[i][j];
                    int x = deltas[k*2][0];
                    int y = deltas[k*2][1];
                    if (inRange(i+x, j+y)==false) {
                        continue;
                    } else{
                        temp += board[i+x][j+y];
                    }
                    x = deltas[k*2+1][0];
                    y = deltas[k*2+1][1];
                    if (inRange(i+x, j+y)==false) {
                        continue;
                    } else{
                        temp += board[i+x][j+y];
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
    }

    private static void check2() {
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++) {
                for (int k=0;k<2;k++) {
                    int temp = board[i][j];
                    int x = deltas2[k*2][0];
                    int y = deltas2[k*2][1];
                    if (inRange(i+x, j+y)==false) {
                        continue;
                    } else{
                        temp += board[i+x][j+y];
                    }
                    x = deltas2[k*2+1][0];
                    y = deltas2[k*2+1][1];
                    if (inRange(i+x, j+y)==false) {
                        continue;
                    } else{
                        temp += board[i+x][j+y];
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}