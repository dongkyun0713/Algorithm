package baekjoon.ds;

import java.io.*;
import java.util.*;

public class B1972 {
    static final String AMAZING = " is surprising.\n";
    static final String NOT_AMAZING = " is NOT surprising.\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;

            int n = s.length();
            if (n <= 2) {
                sb.append(s).append(AMAZING);
                continue;
            }

            boolean amazing = true;

            for (int D = 1; D <= n - 2 && amazing; D++) {
                Set<String> seen = new HashSet<>();

                for (int i = 0; i + D < n; i++) {
                    String key = "" + s.charAt(i) + s.charAt(i + D);
                    if (!seen.add(key)) {
                        amazing = false;
                        break;
                    }
                }
            }

            sb.append(s).append(amazing ? AMAZING : NOT_AMAZING);
        }

        System.out.print(sb);
    }
}