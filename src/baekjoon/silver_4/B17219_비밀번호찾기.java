package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, String > map = new HashMap<>();

        while (n -- > 0) {
          String input2[] = br.readLine().split(" ");
          map.put(input2[0], input2[1]);
        }
        StringBuilder sb = new StringBuilder();
        while (m -- > 0){
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");
        }
        System.out.println(sb);
    }
}
