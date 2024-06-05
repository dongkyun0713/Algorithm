package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B9375_패션왕신혜빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n -- > 0){
            int m = Integer.parseInt(br.readLine());
            Map<String ,Integer> map = new HashMap<>();
            while (m -- >0){
                String input[] = br.readLine().split(" ");

                if(map.containsKey(input[1])) map.put(input[1], map.get(input[1]) + 1);
                else map.put(input[1], 2);
            }
            int result = 1;
            for(int k : map.values()){
                result *= k;
            }
            sb.append(result -1).append("\n");
        }
        System.out.println(sb);
    }
}
