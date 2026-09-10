import java.io.*;

public class Main {
    private static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nStr = bf.readLine().trim();
        int L = nStr.length();
        int[] d = new int[L];
        for (int i = 0; i < L; i++) d[i] = nStr.charAt(i) - '0';

        //  N mod p (전체 1~N의 개수, mod p)
        long nModP = 0;
        for (int i = 0; i < L; i++) {
            nModP = (nModP * 10 + d[i]) % MOD;
        }

        //  금지 숫자(3,6,9)를 전혀 포함하지 않고, 3의 배수도 아닌 수(=박수 안 치는 수)의 개수를
        //    자릿수 DP로 세어본다.
        //
        // dp[tight][started][sumMod] : 현재까지 진행한 자릿수에서
        //   tight   : 지금까지 N의 접두사와 완전히 같게 진행했는지 여부
        //   started : 아직 앞자리 0들만 나왔는지(=수가 아직 시작 안 됐는지) 여부
        //   sumMod  : 지금까지(수가 시작된 이후) 자릿수 합을 3으로 나눈 나머지
        //
        // tight: 0=false, 1=true / started: 0=false, 1=true / sumMod: 0,1,2
        long[][][] dp = new long[2][2][3];
        dp[1][0][0] = 1; // 시작 전: tight=true, 아직 시작 안 함, sumMod=0

        boolean[] forbidden = new boolean[10];
        forbidden[3] = true;
        forbidden[6] = true;
        forbidden[9] = true;

        for (int i = 0; i < L; i++) {
            long[][][] ndp = new long[2][2][3];

            for (int tight = 0; tight < 2; tight++) {
                for (int started = 0; started < 2; started++) {
                    for (int sumMod = 0; sumMod < 3; sumMod++) {
                        long cur = dp[tight][started][sumMod];
                        if (cur == 0) continue;

                        int maxDigit = (tight == 1) ? d[i] : 9;

                        for (int digit = 0; digit <= maxDigit; digit++) {
                            if (forbidden[digit]) continue; // 3,6,9는 애초에 선택 불가 (금지 숫자 포함하면 안 되므로)

                            int newTight = (tight == 1 && digit == maxDigit) ? 1 : 0;

                            int newStarted;
                            int newSumMod;
                            if (started == 1) {
                                newStarted = 1;
                                newSumMod = (sumMod + digit) % 3;
                            } else {
                                if (digit == 0) {
                                    newStarted = 0;
                                    newSumMod = 0; // 아직 시작 안 함 (앞자리 0)
                                } else {
                                    newStarted = 1;
                                    newSumMod = digit % 3;
                                }
                            }

                            ndp[newTight][newStarted][newSumMod] =
                                    (ndp[newTight][newStarted][newSumMod] + cur) % MOD;
                        }
                    }
                }
            }

            dp = ndp;
        }

        // "박수 안 치는 수" = 시작이 됐고(즉 0이 아니고), 3으로 나눈 나머지가 0이 아닌 경우
        long unclapped = 0;
        for (int tight = 0; tight < 2; tight++) {
            unclapped = (unclapped + dp[tight][1][1]) % MOD;
            unclapped = (unclapped + dp[tight][1][2]) % MOD;
        }

        long ans = ((nModP - unclapped) % MOD + MOD) % MOD;
        System.out.println(ans);
    }
}