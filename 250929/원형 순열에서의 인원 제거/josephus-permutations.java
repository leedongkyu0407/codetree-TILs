import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            q.add(i+1);
        }

        while(q.size()!=0) {
            for(int i=0;i<3;i++){
                q.add(q.poll());
            }
            res.add(q.poll());
        }

        for(int i=0;i<N;i++){
            sb.append(res.get(i));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}