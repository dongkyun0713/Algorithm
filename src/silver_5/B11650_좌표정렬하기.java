package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        for(int i = 0; i < n; i++) {
            String input[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순

        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1] + "\n");
        }
        System.out.println(sb);
    }
}
