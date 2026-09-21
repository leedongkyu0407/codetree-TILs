import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(hm.containsKey(k-num)) ans+=hm.get(k-num);
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        System.out.println(ans);
    }
}