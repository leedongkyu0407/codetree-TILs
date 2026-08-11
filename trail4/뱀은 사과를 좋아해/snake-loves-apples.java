import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, k, t;
    private static boolean[][] apples;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] snake;
    private static ArrayDeque<Pos> ad = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        apples = new boolean[n+1][n+1];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apples[x][y] = true;
        }

        t = 0;
        snake = new boolean[n+1][n+1];
        snake[1][1] = true;
        ad.addFirst(new Pos(1, 1));

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            String dir = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            boolean flag = move(dir, amount);
            if(flag) break; 
        }

        System.out.println(t);
    }

    private static boolean move(String dir, int amount) {
    
        int d = 0;
        if("D".equals(dir)) {
            d = 1;
        } else if ("R".equals(dir)) {
            d = 2;
        } else if ("L".equals(dir)) {
            d = 3;
        }

        for(int i=0;i<amount;i++) {
            t++;
            Pos head = ad.getFirst();
            int nx = head.x+deltas[d][0];
            int ny = head.y+deltas[d][1];
            if(!inRange(nx, ny)) return true;
            
            // 사과 없으면
            if(!apples[nx][ny]) {
                Pos tail = ad.pollLast();
                snake[tail.x][tail.y] = false;
            } else {
                apples[nx][ny] = false;
            }

            if(snake[nx][ny]) return true;

            ad.addFirst(new Pos(nx, ny));
            snake[nx][ny] = true;
        }
        return false;
    }
    
    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}