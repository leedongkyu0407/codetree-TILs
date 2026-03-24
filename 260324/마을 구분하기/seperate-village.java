import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, town, cnt;
    private static int[][] board;
    private static boolean[][] visited;
    private static List<Integer> people = new ArrayList<>();
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        town = 0;
        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x=0;x<n;x++) {
            for(int y=0;y<n;y++) {
                if (!(isPerson(x, y))) continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                town++;
                cnt = 1;
                dfs(x, y);
                people.add(cnt);
            }
        }

        print();
    }

    private static void dfs(int x, int y) {
        for(int[] delta : deltas) {
            int nx = x+delta[0];
            int ny = y+delta[1];
            if (!(inRange(nx, ny)&&isPerson(nx, ny))) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            cnt++;
            dfs(nx, ny);
        }
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    private static boolean isPerson(int x, int y) {
        return board[x][y]==1;
    }

    private static void print() {
        Collections.sort(people);
        StringBuilder sb = new StringBuilder();
        sb.append(town).append("\n");
        
        for(int i=0;i<people.size();i++) {
            sb.append(people.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}