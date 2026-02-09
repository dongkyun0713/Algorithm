package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {
    static int N;
    static int[] request;
    static int allow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        request = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            request[i] = Integer.parseInt(st.nextToken());
        }
        allow = Integer.parseInt(br.readLine());

        Arrays.sort(request);
        System.out.println(parametricSearchMax(1, request[N - 1]));
    }

    private static int parametricSearchMax(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getCount(mid);
            if (cnt <= allow) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static int getCount(int mid) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += Math.min(request[i], mid);
        }
        return cnt;
    }
}
