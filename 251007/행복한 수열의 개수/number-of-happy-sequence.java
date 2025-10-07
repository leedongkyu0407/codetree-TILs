import java.util.*;
import java.io.*;
  
public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        int ans = checkRow();
        ans += checkCol();
        System.out.println(ans);
    }

    private static int checkRow() {
        int cntRow = 0;
        for (int i=0;i<N;i++) {
            int temp = 0;
            boolean flag = false;
            for (int j=0;j<N-1;j++) {
                if (board[i][j] == board[i][j+1]) {
                    temp++;
                }
                if(temp == M-1) {
                    flag = true;
                } else {
                    temp = 0;
                }
            }
            if (flag == true) {
                cntRow++;
            }
        }
        return cntRow;
    }

    private static int checkCol() {
        int cntCol = 0;
        for (int i=0;i<N;i++) {
            int temp = 0;
            boolean flag = false;
            for (int j=0;j<N-1;j++) {
                if (board[j][i] == board[j+1][i]) {
                    temp++;
                }
                if(temp == M-1) {
                    flag = true;
                } else {
                    temp = 0;
                }
            }
            if (flag == true) {
                cntCol++;
            }
        }
        return cntCol;
    }
}