import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, ans;
    private static int[] nums;
    private static List<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        comb(0, 0);
        System.out.println(ans);
    }

    private static void comb(int depth, int cnt) {
        if (depth == n) {
            if (cnt == m) {
                sol();
            }
            return;
        }

        al.add(nums[depth]);
        comb(depth+1, cnt+1);
        al.remove(al.size()-1);

        comb(depth+1, cnt);
    }

    private static void sol() {
        int temp = 0;
        for(int i=0;i<al.size();i++) {
            temp ^= al.get(i);
        }
        ans = Math.max(ans, temp);
    }
}