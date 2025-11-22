package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14501 {
    static int[] memo;
    static List<Schedule> list;
    static int n;

    private static class Schedule {
        int time;
        int payment;

        public Schedule(int time, int payment) {
            this.time = time;
            this.payment = payment;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Schedule schedule = new Schedule(t, p);
            list.add(schedule);
        }

        System.out.println(dfs(0));
    }

    private static int dfs(int day) {
        if (day >= n) return 0;

        if (memo[day] != 0) {
            return memo[day];
        }

        int skip = dfs(day + 1);  // 오늘 안함

        int take = 0;  // 오늘 함
        Schedule s = list.get(day);
        if (day + s.time <= n) {
            take = s.payment + dfs(s.time + day);
        }

        return memo[day] = Math.max(skip, take);
    }
}
