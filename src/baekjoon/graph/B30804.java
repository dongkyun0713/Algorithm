package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] fruits = new int[10];
        int left = 0;
        int typeCount = 0;
        int max = 0;

        for (int right = 0; right < N; right++) {
            if (fruits[arr[right]] == 0) typeCount++;
            fruits[arr[right]]++;

            while (typeCount > 2) {
                fruits[arr[left]]--;
                if (fruits[arr[left]] == 0) typeCount--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }


        System.out.println(max);
    }
}
