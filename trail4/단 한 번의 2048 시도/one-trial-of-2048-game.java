import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board = new int[4][4];
    private static String dir;
    private static Map<String, Integer> hm = new HashMap<String, Integer>() {
        {
            put("L", 1);
            put("R", 3);
            put("U", 2);
            put("D", 0);
        }
    };

    public static void main(String[] args) throws IOException{
        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<4;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = bf.readLine();
        solve(hm.get(dir));

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve(int d) {
        for(int i=0;i<d;i++) {
            rotate();
        }

        down();

        for(int i=0;i<4-d;i++) {
            rotate();
        }
    }

    private static void down() { 
        int[][] temp = new int[4][4];

        for(int i=0;i<4;i++) {
            int now = 0;
            int nx = 3;

            for(int j=3;j>=0;j--) {
                if (board[j][i]==0) continue;

                if (now==0) {
                    now = board[j][i];
                } else if (now == board[j][i]) {
                    temp[nx--][i] = now*2;
                    now = 0;
                } else {
                    temp[nx--][i] = now;
                    now = board[j][i];
                }
            }
            
            if(now != 0) {
                temp[nx--][i] = now;
            }
        }

        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    private static void rotate() {
        int[][] temp = new int[4][4];

        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                temp[i][j] = board[j][3-i];
            }
        }
        board = temp;
    }
}