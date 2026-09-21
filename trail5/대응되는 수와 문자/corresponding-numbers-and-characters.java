import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> hm = new HashMap<>();
        Map<String, String> hm2 = new HashMap<>();
        for(int i=1;i<=n;i++) {
            String s = bf.readLine();
            hm.put(s, Integer.toString(i));
            hm2.put(Integer.toString(i), s);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            String t = bf.readLine();
            if(hm.containsKey(t)) {
                sb.append(hm.get(t));
            } else if(hm2.containsKey(t)) {
                sb.append(hm2.get(t));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}