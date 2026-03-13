import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static String ans = "";
    private static StringBuilder sb = new StringBuilder();
    private static char[] chars = new char[]{'4', '5', '6'};
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        perm(new StringBuilder());
        System.out.println(ans);
    }

    private static boolean perm(StringBuilder sb) {
        if (sb.length() == n) {
            ans = sb.toString(); 
            return true;
        }

        for(char c : chars) {
            sb.append(c);
            if (isPossible(sb.toString())) {
                if(perm(sb)) {
                    return true;
                }
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }

    private static boolean isPossible(String s) {
        int len = s.length();
        for(int i=1;i<len/2+1;i++) {
            String last = s.substring(len-i);
            String prev = s.subString(len-(i*2), len-i);
            if (last.equals(prev)) {
                return false;
            }
        }
        return true;
    }
}