package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1010_다리놓기 {
    public static int dp[][] =  new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i =0; i < T; i++) {
            String arr[] = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            System.out.println(combination(b, a));
        }
    }
    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
        else if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        // 일반적인 경우
        else {
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
