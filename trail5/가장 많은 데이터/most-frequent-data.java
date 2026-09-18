import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Map<String, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            String s = bf.readLine();
            hm.put(s, hm.getOrDefault(s, 0)+1);
        }

        int ans = 0;
        for(int cnt : hm.values()) {
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}