import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] board;
    static int ans = 0;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++){
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }
        calc();
        System.out.println(ans);
    }

    private static int getCost(int k) {
        return k*k+(k+1)*(k+1);
    }

    private static int calcGold(int x, int y, int k) {
        int total = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (Math.abs(x-i)+Math.abs(y-j)<=k) {
                    if (board[i][j]==1)
                        total++;
                }
            }
        }
        return total;
    }

    private static void calc() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                for (int k=0;k<=2*(N-1);k++) {
                    int gold = calcGold(i, j, k);
                    if(gold*M >= getCost(k)) {
                        ans = Math.max(ans, gold);
                    }
                }
            }
        }
    }
}