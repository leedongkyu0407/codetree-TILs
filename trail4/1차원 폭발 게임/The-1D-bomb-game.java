import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static List<Integer> nums;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();
        for(int i=0;i<n;i++) {
            nums.add(Integer.parseInt(bf.readLine()));
        }

        solve();
    }

    private static void solve() {
        
        while(explode()) {}

        StringBuilder sb = new StringBuilder();
        sb.append(nums.size()).append("\n");
        for(int i=0;i<nums.size();i++) {
            sb.append(nums.get(i)).append("\n");
            
        }
        System.out.println(sb.toString());
    }

    private static boolean explode() {
        boolean[] toRemove = new boolean[nums.size()];
        int i=0;
        boolean exploded = false;

        while(i<nums.size()) {
            int start = i;
            int current = nums.get(i);
            int count = 0;

            while(i < nums.size() && nums.get(i)==current) {
                count++;
                i++;
            }

            if(count >= m) {
                exploded = true;
                for (int j=start; j<start+count;j++) {
                    toRemove[j] = true;
                }
            }
        }

        if (exploded) {
            List<Integer> newNums = new ArrayList<>();
            for(int j=0;j<nums.size();j++) {
                if (!toRemove[j]) {
                    newNums.add(nums.get(j));
                }
            }
            nums = newNums;
        }

        return exploded;
    }
}