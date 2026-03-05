package baekjoon.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B4195 {
    static int[] parent;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent = new int[F * 2]; // 친구 관계가 F개면 최대 인원은 F * 2명
            count = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                count[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>();
            int id = 0;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) map.put(a, id++);
                if (!map.containsKey(b)) map.put(b, id++);

                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            count[x] += count[y];
        }
        return count[x];
    }

}
