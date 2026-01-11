package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] arr = new Integer[s.length()];
        int sum = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
            sum += num;
            if (num == 0) {
                ++zeroCount;
            }

            arr[i] = num;
        }
        if (sum % 3 != 0 || zeroCount == 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }
}
