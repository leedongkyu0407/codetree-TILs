import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(o.equals("find")) {
                sb.append(s.contains(num)).append("\n");
            } else if (o.equals("add")) {
                s.add(num);
            } else if (o.equals("remove")) {
                s.remove(num);
            }
        }

        System.out.println(sb.toString());
    }
}