package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    static int N;
    static long M;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            trees[i] = h;
            if (h > right) {
                right = h;
            }
        }

        System.out.println(parametricSearchMax(0, right));
    }

    private static int parametricSearchMax(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long got = getCount(mid);

            if (got >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static long getCount(int h) {
        long sum = 0L;
        for (int t : trees) {
            if (t > h) {
                sum += (t - h);
            }
        }
        return sum;
    }
}
