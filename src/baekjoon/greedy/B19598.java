package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19598 {
    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return a.end - b.end;
        });
        Queue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for (Meeting m : meetings) {
            while (!pq.isEmpty() && pq.peek() <= m.start) {
                pq.poll();
            }
            pq.add(m.end);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}
