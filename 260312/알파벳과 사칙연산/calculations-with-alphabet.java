import java.util.*;
import java.io.*;

public class Main {
    private static Map<Character, Integer> maps = new HashMap<>();
    private static Set<Character> variables = new HashSet<>();
    private static List<Character> varList;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static String expression;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        expression = bf.readLine();

        for(char c: expression.toCharArray()) {
            if (c >= 'a' && c<='f') {
                variables.add(c);
            }
        }
        varList = new ArrayList<>(variables);        
        comb(0);
        System.out.println(ans);
    }

    private static void comb(int cnt) {
        if (cnt == varList.size()) {
            ans = Math.max(ans, calc());
            return;
        }

        char var = varList.get(cnt);
        for (int i=1;i<=4;i++) {
            maps.put(var, i);
            comb(cnt+1);
        }
    }

    private static int calc() {
        int res = 0;
        char oper = '+';

        for(int i=0;i<expression.length();i++) {
            char ch = expression.charAt(i);
            
            if(ch >= 'a' && ch<='f') {
                int num = maps.get(ch);

                if(oper == '+') {
                    res += num;
                } else if (oper == '-') {
                    res -= num;
                } else if (oper == '*') {
                    res *= num;
                }
            } else {
                oper = ch;
            }
        }
        return res;
    }
}