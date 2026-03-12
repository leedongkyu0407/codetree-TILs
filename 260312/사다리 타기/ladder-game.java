import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, a, b, ans;
    static int[][] ladders;
    static int[] originalRes;
    static List<int[]> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ladders = new int[m+1][n+1];
        ans = m;

        for(int i = 0; i < m; i++){
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(inputs.nextToken());
            b = Integer.parseInt(inputs.nextToken());
            lines.add(new int[]{a, b});
            ladders[b][a] = 1;
            ladders[b][a+1] = -1;
        }

        originalRes = simul();
        backtrack(0, 0);
        System.out.println(ans);
    }

    private static int[] simul() {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++) {
            int pos = i;
            for (int j=1;j<=m;j++) {
                if(ladders[j][pos]!=0) {
                    pos += ladders[j][pos];
                }
            }
            res[i] = pos;
        }
        return res;
    }

    private static boolean isSame(int[] current) {
        for(int i=1;i<=n;i++) {
            if(current[i]!=originalRes[i]) {
                return false;
            }
        }
        return true;
    }

    private static void backtrack(int depth, int removed) {
        if (depth == m) {
            int[] current = simul();
            if (isSame(current)) {
                ans = Math.min(ans, m-removed);
            }    
            return;
        }

        int[] line = lines.get(depth);
        // 유지
        int pos = line[0];
        int h = line[1];
        backtrack(depth+1, removed);

        // 제거
        ladders[h][pos] = 0;
        ladders[h][pos+1] = 0;
        backtrack(depth+1, removed+1);
        ladders[h][pos] = 1;
        ladders[h][pos+1] = -1;
    }    
}