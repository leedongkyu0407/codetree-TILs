import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] board;
    private static int[][] deltas = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    private static boolean[][] visited;
    private static int[] start = new int[2];
    private static int[] end = new int[2];

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLIne());
        board = new int[n+1][n+1];
        visited = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[0] = Integer.parseInt(st.nextToken());
        start[0] = Integer.parseInt(st.nextToken());

    }
}