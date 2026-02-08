package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, f);
        }
        Arrays.sort(meetings, (a, b) -> {
            if (a. finish!= b.finish) {
                return a.finish- b.finish;
            }
            return a.start- b.start;
        });

        int count =0;
        int end = 0;

        for (Meeting m : meetings) {
            if (end <= m.start) {
                count++;
                end = m.finish;
            }
        }

        System.out.println(count);
    }

    static class Meeting {
        int start, finish;

        public Meeting(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
