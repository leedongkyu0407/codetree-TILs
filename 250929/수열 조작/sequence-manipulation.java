import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(bf.readLine());
        for(int i=1;i<=N;i++){
            dq.addLast(i);
        }

        while(dq.size()!=1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.pollFirst());
    }
}