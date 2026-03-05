package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) pq.add(x);
            else {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.remove());
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
