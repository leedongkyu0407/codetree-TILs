import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();

            if(o.equals("add")) {
                int n = Integer.parseInt(st.nextToken());
                ts.add(n);
            } else if (o.equals("remove")) {
                int n = Integer.parseInt(st.nextToken());
                ts.remove(n);
            } else if (o.equals("find")) {
                int n = Integer.parseInt(st.nextToken());
                sb.append(ts.contains(n)).append("\n");
            } else if (o.equals("lower_bound")) {
                int n = Integer.parseInt(st.nextToken());
                Integer t = ts.ceiling(n);
                if (t==null) {
                    sb.append("None");
                } else {
                    sb.append(t);
                }
                sb.append("\n");
            } else if (o.equals("upper_bound")) {
                int n = Integer.parseInt(st.nextToken());
                Integer t = ts.higher(n);
                if (t==null) {
                    sb.append("None");
                } else {
                    sb.append(t);
                }
                sb.append("\n");
            } else if (o.equals("largest")) {
                if(ts.isEmpty()) {
                    sb.append("None");
                } else {
                    sb.append(ts.last());
                }
                sb.append("\n");
            } else if (o.equals("smallest")) {
                if(ts.isEmpty()) {
                    sb.append("None");
                } else {
                    sb.append(ts.first());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}