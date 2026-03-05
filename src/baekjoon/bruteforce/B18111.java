package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] < min) min = map[i][j];
                if (map[i][j] > max) max = map[i][j];
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;

        // 가능한 모든 높이(0~256)에 대해 탐색
        // 문제 조건상 min~max 사이만 확인해도 무방함
        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = map[i][j] - h;

                    if (diff > 0) { // 제거 (2초)
                        time += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) { // 쌓기 (1초)
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            // 인벤토리가 음수가 아니면 가능한 경우
            if (inventory >= 0) {
                if (time <= answerTime) {
                    // 시간이 같으면 높은 높이를 선택해야 하므로 <= 사용
                    answerTime = time;
                    answerHeight = h;
                }
            }
        }
        System.out.println(answerTime + " " + answerHeight);
    }
}