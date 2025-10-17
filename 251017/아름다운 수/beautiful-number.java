import java.util.Scanner;
public class Main {
    static int n;
    static int ans = 0;
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n+1];
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int k) {
        if (k==n){
            int cnt = 1;
            for(int i=1;i<n;i++) {
                if (list[i-1] != list[i]) {
                    if ((cnt) % list[i-1] != 0) {
                        return;
                    }
                    cnt = 1;
                } else {
                    cnt++;
                } 
            }
            if ((cnt) % list[n-1] != 0) {
                return;
            }
            ans++;
            return;
        } 

        for (int i=1;i<=4;i++) {
            list[k] = i;
            dfs(k+1);
        }
    }
}