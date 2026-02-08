package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int house= Integer.parseInt(br.readLine());
            arr[i] = house;
        }
        Arrays.sort(arr);

        System.out.println(parametricSearchMax(1, arr[N - 1]));
    }

    private static int parametricSearchMax(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = getCount(mid);
            if (cnt >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static int getCount(int l) {
        int cnt = 1;
        int last = arr[0];
        for (int i = 1; i < N; i++) {
            if (l <= arr[i] - last) {
                cnt++;
                last = arr[i];
            }
        }
        return cnt;
    }
}
