package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tall = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            tall[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = n; i >= 1; i--) {
            ans.add(tall[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int k : ans) {
            sb.append(k).append(" ");
        }
        System.out.println(sb);
    }
}
