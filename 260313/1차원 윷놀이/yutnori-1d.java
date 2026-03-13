import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, k, ans;
    private static int[] moves;
    private static List<Integer> horses = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        moves = new int[n+1];
        StringTokenizer inputs = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            moves[i] = Integer.parseInt(inputs.nextToken());
        }
        ans = 0;
        perm(0);
        System.out.println(ans);
    }

    private static void perm(int cnt) {
        if (cnt == n) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i=1;i<=k;i++) {
            horses.add(i);
            perm(cnt+1);
            horses.remove(horses.size()-1);
        }
    }

    private static int calc() {
        int res = 0;
        int[] board = new int[k+1];
        for(int i=0;i<horses.size();i++) {
            board[horses.get(i)] += moves[i+1];
        }
        for(int b : board) {
            if (b >= m-1) {
                res++;
            }
        }
        return res;
    }
}