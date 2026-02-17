package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int left1 = 0;
            int right1 = s.length() - 1;
            int left2 = 0;
            int right2 = s.length() - 1;
            int cnt1 = 0;
            int cnt2 = 0;


            while (left1 < right1) {
                if (s.charAt(left1) != s.charAt(right1)) {
                    left1++;
                    cnt1++;
                } else {
                    left1++;
                    right1--;
                }
            }

            while (left2 < right2) {
                if (s.charAt(left2) != s.charAt(right2)) {
                    right2--;
                    cnt2++;
                } else {
                    left2++;
                    right2--;
                }
            }

            if (cnt1 == 0) sb.append(0);
            else if (cnt1 == 1 || cnt2 == 1) sb.append(1);
            else sb.append(2);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
