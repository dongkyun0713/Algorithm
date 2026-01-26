package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }
        Arrays.sort(lectures, (a, b) -> {
            if (a.s != b.s) return a.s - b.s;
            return a.t - b.t;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].t);

        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty() && pq.peek() <= lectures[i].s) {
                pq.remove();
            }
            pq.add(lectures[i].t);
        }
        System.out.println(pq.size());

    }

    private static class Lecture {
        int s;
        int t;

        public Lecture(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
