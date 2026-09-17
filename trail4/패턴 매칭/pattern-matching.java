import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine().trim();
        String P = bf.readLine().trim();

        int n = S.length();
        int m = P.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int j=1;j<=m;j++) {
            if(P.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                char pc = P.charAt(j-1);

                if(pc=='*') {
                    char prevPc = P.charAt(j-2);

                    boolean zeroCase = dp[i][j-2];

                    boolean moreCase = false;
                    if(prevPc=='.' || prevPc==S.charAt(i-1)) {
                        moreCase = dp[i-1][j];
                    }

                    dp[i][j] = zeroCase || moreCase;
                } else if (pc=='.' || pc==S.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}