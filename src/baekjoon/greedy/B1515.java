package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        int cur = 1;

        while (true) {
            String t = String.valueOf(cur);
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                    if (idx == s.length()) {
                        System.out.println(cur);
                        return;
                    }
                }
            }
            cur++;
        }

    }
}
