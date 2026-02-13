package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            List<String> numbers = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                numbers.add(br.readLine());
            }
            Collections.sort(numbers);

            int cnt = 0;
            for (int j = 0; j < n - 1; j++) {
                if (numbers.get(j + 1).startsWith(numbers.get(j))) {
                    cnt++;
                }
            }
            if (cnt > 0) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.print(sb);
    }
}
