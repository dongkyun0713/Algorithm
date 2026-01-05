package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            String s = String.valueOf(i);
            int count = s.length();
            for (int j = 0; j < s.length(); j++) {
                int d = s.charAt(j) - '0';
                if (broken[d]) {
                    count = -1;
                    break;
                }
            }
            if (count == -1) continue;
            int press = count + Math.abs(N - i);
            if (ans > press) ans = press;
        }
        System.out.println(ans);
    }
}
