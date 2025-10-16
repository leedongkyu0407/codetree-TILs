import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] board;
    static int[][] deltas = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        calc();
        System.out.println(ans);
    }

    private static void calc() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                for (int w=1;w<=N;w++) {
                    for (int h=1;h<=N;h++) {
                        int score = getScore(i, j, w, h);
                        ans = Math.max(ans, score);
                    }
                }
            }
        }
    }

    private static int getScore(int x, int y, int w, int h) {
        int[] moveSizes = {w, h, w, h};
        int score = 0;

        for (int dir = 0;dir<4;dir++) {
            int len = moveSizes[dir];
            int dx = deltas[dir][0];
            int dy = deltas[dir][1];

            for (int l=0;l<len;l++) {
                x += dx;
                y += dy;

                if (!inRange(x, y)) return 0;

                score += board[x][y];
            }
        }
        return score;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}