package baekjoon.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2343 {
    static int N, M;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lectures = new int[N];
        String[] inputLectures = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(inputLectures[i]);
        }

        int left = Arrays.stream(lectures).max().getAsInt(); // 최소 블루레이 크기
        int right = Arrays.stream(lectures).sum(); // 최대 블루레이 크기

        System.out.println(parametricSearchMin(left, right));
    }

    private static int getCount(int size) {
        int count = 1, sum = 0;
        for (int lecture : lectures) {
            if (sum + lecture <= size) {
                sum += lecture;
            } else {
                count++;
                sum = lecture;
            }
        }
        return count;
    }

    private static int parametricSearchMin(int left, int right) {
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(mid);

            if (count <= M) { // 블루레이 M개 이하로 가능하다면 → 더 줄여보기
                answer = mid;
                right = mid - 1;
            } else {          // 블루레이 개수 초과 → 크기 늘려야 함
                left = mid + 1;
            }
        }
        return answer;
    }
}
