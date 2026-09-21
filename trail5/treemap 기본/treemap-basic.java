import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();
            if(o.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tm.put(a, b);
            } else if (o.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                tm.remove(k);
            } else if (o.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                if(tm.containsKey(k)) {
                    sb.append(tm.get(k));                    
                } else {
                    sb.append("None");
                }
                sb.append("\n");
            } else if (o.equals("print_list")) {
                if (tm.isEmpty()) {
                    sb.append("None");
                } else {
                    StringBuilder line = new StringBuilder();
                    for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
                        if (line.length() > 0) line.append(" ");
                        line.append(entry.getValue());
                    }
                    sb.append(line);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}