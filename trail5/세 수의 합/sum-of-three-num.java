import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0;i<n;i++) {        
            Map<Integer, Integer> hm = new HashMap<>();
            for(int j=i+1;j<n;j++) {
                int need = k-nums[i]-nums[j];
                ans += hm.getOrDefault(need, 0);

                hm.put(nums[j], hm.getOrDefault(nums[j], 0)+1);
            }
        }
        System.out.println(ans);
    }
}