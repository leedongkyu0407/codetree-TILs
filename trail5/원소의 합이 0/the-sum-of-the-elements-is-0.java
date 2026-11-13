import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] nums;
    private static Map<Integer, Integer> hm = new HashMap<>();
    private static Map<Integer, Integer> hm2 = new HashMap<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[4][n];

        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    private static int solve() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int k = nums[0][i]+nums[1][j];
                if(!hm.containsKey(k)) {
                    hm.put(k, 1);
                } else {
                    hm.put(k, hm.get(k)+1);
                }

                k = nums[2][i]+nums[3][j];
                if(!hm2.containsKey(k)) {
                    hm2.put(k, 1);
                } else {
                    hm2.put(k, hm2.get(k)+1);
                }
            }
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int tmp = entry.getKey();
            if(hm2.containsKey((tmp*-1))) {
                ans += (hm.get(tmp)) * (hm2.get((tmp*-1)));
            }
        }

        return ans;
    }

}