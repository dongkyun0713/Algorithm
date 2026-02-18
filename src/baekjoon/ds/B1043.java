package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1043 {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 파티의 수
        graph = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = (Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            if (party.size() > 1) {
                for (int a = 0; a < party.size(); a++) {
                    for (int b = a + 1; b < party.size(); b++) {
                        int u = party.get(a);
                        int v = party.get(b);
                        graph[u][v] = graph[v][u] = 1;
                    }
                }

            }
        }

        visited = new boolean[N+1];
        for (int i = 0; i < truthCount; i++) {
            if (!visited[truthPeople[i]]) dfs(truthPeople[i]);
        }

        int answer = 0;

        for (List<Integer> party : parties) {
            boolean lie = true;
            for (int p : party) {
                if (visited[p]) {
                    lie = false;
                    break;
                }
            }
            if (lie) answer++;
        }

        System.out.println(answer);
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
