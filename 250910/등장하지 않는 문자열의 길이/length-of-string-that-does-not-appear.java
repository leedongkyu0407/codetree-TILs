import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int ans = 0;
    static String s;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        s = bf.readLine();

        for(int i=1;i<N/2+1;i++) {
            check(i);
        }
        System.out.println(ans+1);
    }

    static void check(int len) {
        for(int i=0;i<=N-len+1;i = i+len) {
            String temp = s.substring(i, i+len);
            // System.out.println("i:"+i+", len:"+len+", temp1:"+temp);
            for (int j=i+len;j<N-len+1;j++) {
                String temp2 = s.substring(j, j+len);
                // System.out.println("i:"+i+", j:"+j+", len:"+len+", temp1:"+temp+", temp2:"+temp2);
                if (temp.equals(temp2)) {
                    ans = len;
                    return;
                }
            }
        }
    }
}