package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1654 {
    static int K;
    static long N;           // 필요 개수 비교 시 안전하게 long
    static long[] lanCables; // 케이블 길이도 long

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Long.parseLong(input[1]);

        lanCables = new long[K];
        long right = 0;
        for (int i = 0; i < K; i++) {
            lanCables[i] = Long.parseLong(br.readLine().trim());
            if (lanCables[i] > right) right = lanCables[i];
        }

        long ans = parametricSearchMax(1, right);
        System.out.println(ans);
    }

    private static long getCount(long L) {
        long cnt = 0;
        for (long len : lanCables) {
            cnt += (len / L);
        }
        return cnt;
    }

    // 가능한 최대 길이를 찾는 이분 탐색
    private static long parametricSearchMax(long left, long right) {
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = getCount(mid);

            if (cnt >= N) {        // N개 이상 만들 수 있으면 → 더 길게 시도
                answer = mid;      // 길이(mid)를 정답 후보로 저장
                left = mid + 1;
            } else {               // 부족하면 → 길이를 줄임
                right = mid - 1;
            }
        }
        return answer;
    }
}
