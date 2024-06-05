package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();


        int n = Integer.parseInt(br.readLine());

        while (n -- > 0) {
            String input[] = br.readLine().split("\\.");
            map.put(input[1], map.getOrDefault(input[1], 0)+1);
        }
        List<String> keyset = new ArrayList<>(map.keySet());
        Collections.sort(keyset);

        StringBuilder sb = new StringBuilder();
        for(String key : keyset){
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}
