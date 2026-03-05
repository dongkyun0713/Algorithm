package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B11003 {
    static class Node {
        int idx, val;
        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.getLast().val > x) {
                dq.removeLast();
            }
            dq.addLast(new Node(i, x));

            int left = i - L + 1;

            while (!dq.isEmpty() && dq.peekFirst().idx < left) {
                dq.removeFirst();
            }
            sb.append(dq.getFirst().val).append(" ");

        }
        System.out.println(sb);
    }
}
