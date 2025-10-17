import java.util.*;

public class Main {
    static int[][][] deltas = {{{-2, 0}, {-1, 0}, {0,0}, {1, 0}, {2, 0}}, {{0,0},{-1,0},{0, 1},{1,0},{0,-1}}, {{0,0},{1,1}, {1, -1}, {-1,-1}, {-1, 1}}};
    static int n, bomb;
    static int[][] grid;
    static List<Integer> types = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        bomb = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j]==1) bomb++;
            }
        }
        perm(0);
        System.out.println(ans);
    }

    private static void perm(int k) {
        if (k==bomb) {
            ans = Math.max(ans, calc());
            return;
        }

        for (int i=1;i<=3;i++) {
            types.add(i);
            perm(k+1);
            types.remove(types.size()-1);
        }
    }

    private static int calc() {
        int temp=0;
        boolean[][] visited = new boolean[n][n];
        int idx = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    int t = types.get(idx)-1;
                    idx++;
                    for(int l=0;l<5;l++) {
                        int targetX = i+deltas[t][l][0];
                        int targetY = j+deltas[t][l][1];
                        if((targetX<0 || targetX>=n || targetY<0 || targetY>=n) || visited[targetX][targetY])
                            continue;
                        visited[targetX][targetY] = true;
                        temp++;
                    }
                }
            }
        }
        return temp;
    }
}