package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16953 {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B = B / 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            cnt++;
        }
        if (B == A) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

}
