package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            input = input.substring(1, input.length() - 1);
            String[] parts = input.split(",");

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(parts[j]));
            }

            AC(p, list);
        }
        System.out.print(sb);
    }
    private static void AC(String p, List<Integer> list) {
        boolean reversed = false;
        Deque<Integer> deque = new ArrayDeque<>(list);

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                reversed = !reversed;
            }

            else if (p.charAt(i) == 'D') {
                if (!deque.isEmpty()) {
                    if (!reversed) deque.removeFirst();
                    else deque.removeLast();
                } else {
                    sb.append("error\n");
                    return;
                }
            }
        }
        sb.append("[");
        int size = deque.size();
        if (!reversed) {
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.removeFirst()).append(",");
            }
            if (!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.removeLast()).append(",");
            }
            if (!deque.isEmpty()) {
                sb.append(deque.removeLast());
            }
        }

        sb.append("]\n");
    }
}
