package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2352 {
    static int n;
    static Port[] ports;
    static int[] memo;
    
    static class Port {
        int start, end;

        public Port(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ports = new Port[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ports[i] = new Port(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(ports, (a, b) -> a.start - b.start);
        
        memo = new int[n];
        Arrays.fill(memo, -1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i));
        }

        System.out.println(max);
    }
    
    private static int dfs(int idx) {
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int best = 1;
        for (int i = 0; i < idx; i++) {
            if (ports[i].end < ports[idx].end) {
                best = Math.max(best, dfs(i) + 1);
            }
        }
        return memo[idx] = best;
    }
}
