import java.util.Scanner;

public class Main {
    static int[] list;
    static int n, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        list = new int[n];
        getN(0);
    }

    private static void getN(int v) {
        if (v==n) {
            for (int i=0;i<n;i++) {
                System.out.print(list[i]+" ");
            }
            System.out.println();
        } else {
            for (int i=1;i<=k;i++) {
                list[v]=i;
                getN(v+1);
            }
        }
    }
}