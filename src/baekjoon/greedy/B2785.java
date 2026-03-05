package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class B2785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> chain = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chain.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(chain);

        Deque<Integer> dq = new ArrayDeque<>(chain);

        int cnt = 0;
        while (dq.size() != 1) {
            int first = dq.removeFirst();
            if (first != 1) {
                dq.addFirst(first - 1);
            }
            if (dq.size() > 1) {
                dq.addLast(dq.removeLast() + dq.removeLast() + 1);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
