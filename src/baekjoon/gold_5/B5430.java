package baekjoon.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class B5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<String> deque = new ArrayDeque<>();
            if (n > 0) {
                input = input.substring(1, input.length() - 1);
                String[] s = input.split(",");
                Collections.addAll(deque, s);
            }
            boolean isReverse = false;
            boolean isEmpty = false;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.isEmpty()) {
                        isEmpty = true;
                        break;
                    }
                    if (!isReverse) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if (isEmpty) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    while (deque.size() > 1) {
                        if (!isReverse) {
                            sb.append(deque.removeFirst()).append(",");
                        } else {
                            sb.append(deque.removeLast()).append(",");
                        }
                    }
                    sb.append(deque.removeLast());
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
