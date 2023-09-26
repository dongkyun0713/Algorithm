package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++ ) {
            String input[] = br.readLine().split(" ");
            if(input[1].equals("leave")) map.remove(input[0]);
            else map.put(input[0], input[1]);
        }
        List<String> keyList = new ArrayList<>(map.keySet());

        keyList.sort((s1, s2) -> s2.compareTo(s1));
        for(int i = 0; i < keyList.size(); i++){
            System.out.println(keyList.get(i));
        }
    }
}
