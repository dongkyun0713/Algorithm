package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
           int n = Integer.parseInt(st.nextToken());
           max = Math.max(max, n);
            buildings [i] = n;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int len = buildings[i];
            int cnt = 0;
            for (int j = i+1; j < N; j++) {
                cnt++;
                if (len <= buildings[j]) {
                    break;
                }
            }
            for (int j = i-1; j >= 0 ; j--) {
                cnt++;
                if (len <= buildings[j]) {
                    break;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
