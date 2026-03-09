package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder(T);

        while (sb.length() > S.length()) {
            int last = sb.length() - 1;
            if (sb.charAt(last) == 'A') {
                sb.deleteCharAt(last);
            } else {
                sb.deleteCharAt(last);
                sb.reverse();
            }
        }
        System.out.println(sb.toString().equals(S) ? 1 : 0);
    }
}
