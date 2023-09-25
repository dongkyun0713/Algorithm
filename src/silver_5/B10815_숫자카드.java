package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");


        int k = Integer.parseInt(br.readLine());
        String input2[] =  br.readLine().split(" ");

        for(int i = 0; i < k; i++) {
            map.put(Integer.parseInt(input2[i]), 0);
        }

        for(int i = 0; i < n; i++) {
            if(map.containsKey(Integer.parseInt(input[i]))) map.put(Integer.parseInt(input[i]), 1);
        }
        for(int i = 0; i < k; i++) {
            System.out.print(map.get(Integer.parseInt(input2[i])) + " ");
        }

    }


}
