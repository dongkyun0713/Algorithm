package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        while (n -- > 0){
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 1) + 1);
            max = Math.max(max, map.get(s));
        }
        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(max == entry.getValue()) list.add(entry.getKey());
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
