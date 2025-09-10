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

        for(int i=1; i<=N; i++) {
            if(check(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    static boolean check(int len) {
        Map<String, Integer> count = new HashMap<>();
        
        // 모든 길이 len의 부분문자열 개수 세기
        for(int i=0; i<=N-len; i++) {
            String temp = s.substring(i, i+len);
            count.put(temp, count.getOrDefault(temp, 0) + 1);
        }
        
        // 모든 부분문자열이 2번 미만 등장하는지 확인
        for(int freq : count.values()) {
            if(freq >= 2) {
                return false;
            }
        }
        return true;
    }
}