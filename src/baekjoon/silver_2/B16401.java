package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B16401 {
    static int M, N;
    static long[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        M = Integer.parseInt(mn[0]);
        N = Integer.parseInt(mn[1]);

        A = new long[N];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(parts[i]);
        }

        long maxLen = 0;
        for (long len : A) {
            if (len > maxLen) maxLen = len;
        }

        System.out.println(parametricSearch(1, maxLen));
    }

    public static long compare(long middle) {
        long count = 0;
        for (long len : A) {
            count += len / middle;
        }
        return M - count;
    }

    public static long parametricSearch(long left, long right) {
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (compare(mid) <= 0) {
                ans = mid;        // mid로도 충분히 나눠줄 수 있음
                left = mid + 1;   // 더 긴 길이 시도
            } else {
                right = mid - 1;  // 부족하니 길이 줄이기
            }
        }
        return ans;
    }
}
