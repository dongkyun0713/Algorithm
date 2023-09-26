package silver_4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<String> list = new ArrayList<>();
        list.add("");
        Map<String, Integer > map = new HashMap<>();
        for(int i = 1; i < n+1; i++) {
            String name = br.readLine();
            map.put(name, i);
            list.add(name);
        }

        StringBuilder sb = new StringBuilder();

        while(m --> 0) {
            String s = br.readLine();
            if(map.containsKey(s)) {  // 문자를 입력받은 경우
                sb.append(map.get(s));
            }
            else {  // 숫자를 입력받은 경우
                sb.append(list.get(Integer.parseInt(s)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

