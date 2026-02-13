package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3758 {
    static class Team {
        int id;
        int total;
        int submit;
        int last;

        Team(int id, int total, int submit, int last) {
            this.id = id;
            this.total = total;
            this.submit = submit;
            this.last = last;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 수
            int k = Integer.parseInt(st.nextToken()); // 문제 수
            int t = Integer.parseInt(st.nextToken()); // 내 팀
            int m = Integer.parseInt(st.nextToken()); // 로그 수

            int[][] best = new int[n + 1][k + 1];
            int[] submitCnt = new int[n + 1];
            int[] lastIdx = new int[n + 1];

            for (int idx = 1; idx <= m; idx++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                submitCnt[id]++;
                lastIdx[id] = idx;
                if (score > best[id][num]) best[id][num] = score;
            }

            Team[] teams = new Team[n];
            for (int id = 1; id <= n; id++) {
                int sum = 0;
                for (int problem = 1; problem <= k; problem++) sum += best[id][problem];
                teams[id - 1] = new Team(id, sum, submitCnt[id], lastIdx[id]);
            }

            Arrays.sort(teams, (a, b) -> {
                if (a.total != b.total) return b.total - a.total;
                if (a.submit != b.submit) return a.submit - b.submit;
                return a.last - b.last;
            });

            for (int rank = 1; rank <= n; rank++) {
                if (teams[rank - 1].id == t) {
                    sb.append(rank).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
