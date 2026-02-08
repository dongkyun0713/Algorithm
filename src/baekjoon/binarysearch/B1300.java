package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1300 {
    static int N, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(parametricSearchMin(1, k));
    }

    private static int parametricSearchMin(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getCount(mid);
            if (cnt >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private static int getCount(int l) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, l / i);
        }
        return cnt;
    }
}
