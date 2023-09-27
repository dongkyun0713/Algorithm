package silver_4;

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

        List<Integer> list = new ArrayList<>();
        for(int  i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        Collections.sort(list);
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(Objects.equals(list.get(i - 1), list.get(i))) {
                count++;
            }
            else{
                map.put(list.get(i), count);
                count = 0;
            }
        }
        int m = Integer.parseInt(br.readLine());
        String input2[] = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            int card = Integer.parseInt(input2[i]);
            System.out.println(map.get(card));
        }
    }
}
