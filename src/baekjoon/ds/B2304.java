package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        int maxH = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[i][1] = H;

           maxH = Math.max(maxH, H);
        }
        Arrays.sort(arr, Comparator.comparing(o -> o[0]));

        int leftMax = -1, rightMax = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i][1] == maxH) {
                if (leftMax == -1) {
                    leftMax = i;
                }
                rightMax = i;
            }
        }
        long answer = 0;

        int curMax = 0;
        for (int i = 0; i < leftMax; i++) {
            curMax = Math.max(curMax, arr[i][1]);
            int w = arr[i+1][0] - arr[i][0];
            answer += (long) w * curMax;
        }

        curMax = 0;
        for (int i = N-1; i > rightMax; i--) {
            curMax = Math.max(curMax, arr[i][1]);
            int w = arr[i][0] - arr[i-1][0];
            answer += (long) w * curMax;
        }
        
        answer += (long) maxH * (arr[rightMax][0] - arr[leftMax][0]+ 1);

        System.out.println(answer);
    }
}
