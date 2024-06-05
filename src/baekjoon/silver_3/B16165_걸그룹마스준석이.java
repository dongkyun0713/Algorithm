package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16165_걸그룹마스준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            String girlGroup = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            for(int j = 0; j < memberCount; j++ ) {
                String name = br.readLine();
                map1.put(name, girlGroup);
                list.add(name);
            }
            Collections.sort(list);
            for(int k = 0; k < memberCount-1; k++) {
                sb.append(list.get(k)).append("\n");
            }
            sb.append(list.get(memberCount-1));
            map2.put(girlGroup, String.valueOf(sb));
        }
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String name = br.readLine();
            String s = br.readLine();
            if(s.equals("0")) sb.append(map2.get(name)).append("\n");
            else sb.append(map1.get(name)).append("\n");
        }
        System.out.println(sb);
    }
}
