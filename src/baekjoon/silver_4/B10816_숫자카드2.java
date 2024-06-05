package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for(int  i = 0; i < n; i++) {
            int k = Integer.parseInt(input[i]);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String input2[] = br.readLine().split(" ");


        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(input2[i]);
            sb.append(map.getOrDefault(k, 0)).append(' ');
        }

        System.out.println(sb);
    }
}
