import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(hm.get(num)==null) {
                hm.put(num, 1);
            } else {
                hm.put(num, hm.get(num)+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<m;i++) {
            int target = Integer.parseInt(st.nextToken());
            if(hm.get(target)==null) {
                sb.append(0).append(" ");
            } else {
                sb.append(hm.get(target)).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}