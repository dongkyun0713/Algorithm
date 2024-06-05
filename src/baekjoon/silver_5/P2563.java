package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean paper[][] = new boolean[100][100];  // 도화지
        int n = Integer.parseInt(br.readLine());
        int area = 0;  // 검은 종이 넓이

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
