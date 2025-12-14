package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int cur = a;
        int idx = 0;
        while (!map.containsKey(cur)) {
            map.put(cur, idx++);

            String s = String.valueOf(cur);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                sum += (int) Math.pow(digit, p);
            }
            cur = sum;
        }
        System.out.println(map.get(cur));
    }
}
