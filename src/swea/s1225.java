package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class s1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int t = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            int dis = 1;

            while (true) {
                int num = deque.removeFirst();
                if (num - dis > 0) {
                    deque.addLast(num - dis);
                    dis = dis == 5 ? 1 : dis + 1;
                } else {
                    deque.addLast(0);
                    break;
                }
            }
            sb.append("#").append(t).append(" ");
            while (!deque.isEmpty()) {
                sb.append(deque.removeFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
