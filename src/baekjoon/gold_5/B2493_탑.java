package baekjoon.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");

        int[] arr = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Deque<int[]> stack = new ArrayDeque<>(); // [탑의 높이, 인덱스] 저장

        for (int i = 0; i < n; i++) {
            int height = arr[i];

            // 현재 탑보다 낮은 탑들은 신호를 수신할 수 없으므로 제거
            while (!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }

            // 스택이 비어있다면 수신하는 탑이 없음 (0), 아니라면 가장 가까운 탑의 인덱스 저장
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek()[1] + 1;
            }

            // 현재 탑을 스택에 추가
            stack.push(new int[]{height, i});
        }

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            sb.append(res).append(" ");
        }
        System.out.println(sb);
    }
}
