package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int num = 0;
        int idx = 0;
        while (idx < s.length()) {
            num++;
            String t = String.valueOf(num);

            for (int i = 0; i < t.length() && idx < s.length(); i++) {
                if (t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
            }
        }
        System.out.println(num);
    }
}

