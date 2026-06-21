package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5215 {
    static int max;
    static int N, L;
    static Ingredient[] ingredients;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new Ingredient[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                ingredients[i] = new Ingredient(t, c);
            }
            max = 0;
            dfs(0, 0, 0);
            sb.append('#').append(tc).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int idx, int calSum, int tasteSum) {
        if (calSum > L) return;
        if (idx == N) {
            max = Math.max(max, tasteSum);
            return;
        }
        dfs(idx + 1, calSum + ingredients[idx].cal,tasteSum+ ingredients[idx].taste);
        dfs(idx + 1, calSum, tasteSum);
    }

    static class Ingredient {
        int taste, cal;

        public Ingredient(int taste, int cal) {
            this.taste = taste;
            this.cal = cal;
        }
    }
}
