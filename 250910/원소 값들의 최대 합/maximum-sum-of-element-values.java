import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine()); 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N+1];

        StringTokenizer inputs = new StringTokenizer(bf.readLine());
        for (int i=1;i<N+1;i++) {
            numbers[i] = Integer.parseInt(inputs.nextToken());
        }   
        check();
        System.out.println(ans);
        // Please write your code here.
    }

    static void check() {
        int point = 0;
        int sum = 0;
        for (int i=1;i<N+1;i++) {
            point = numbers[i];
            sum = numbers[i];
            for (int j=1;j<M;j++) {
                point = numbers[point];
                sum += point;
            }
            ans = Math.max(ans, sum);
        }
    }
}