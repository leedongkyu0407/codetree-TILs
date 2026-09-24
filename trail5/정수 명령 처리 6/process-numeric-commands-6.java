import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();

            if(o.equals("push")) {
                int t = Integer.parseInt(st.nextToken());
                pq.add(-t);
            } else if (o.equals("pop")) {
                sb.append(-(pq.poll())).append("\n");
            } else if (o.equals("size")) {
                sb.append(pq.size()).append("\n");
            } else if (o.equals("empty")) {
                if(pq.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (o.equals("top")) {
                sb.append(-(pq.peek())).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}