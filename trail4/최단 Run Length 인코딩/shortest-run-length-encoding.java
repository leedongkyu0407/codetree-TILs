import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static String A;

    public static void main(String[] args) throws IOException{
        A = bf.readLine();
        
        int answer = Integer.MAX_VALUE;
        if(A.length()==1) {
            answer = 2;
        } else {
            for(int i=0;i<A.length();i++) {
                answer = Math.min(answer, solve(i));
            }   
        }
        System.out.println(answer);
    }

    private static int solve(int start) {
        StringBuilder sb = new StringBuilder();
        sb.append(A.charAt(start));
        int cnt = 1;

        for(int i=1;i<A.length();i++) {
            if(A.charAt((i+start)%A.length())==A.charAt((i-1+start)%A.length())) {
                cnt++;
            } else {
                sb.append(cnt).append(A.charAt((i+start)%A.length()));
                cnt = 1;
            }
        }

        if(cnt != 0) {
            sb.append(cnt);
        }
        return sb.length();
    }

}