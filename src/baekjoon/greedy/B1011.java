package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = y-x;
            int k = (int) Math.sqrt(d);

            if (d == k * k) sb.append(2 * k - 1);
            else if (d  > k * k && d <= k * k + k) sb.append(2 * k);
            else sb.append(2 * k + 1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
