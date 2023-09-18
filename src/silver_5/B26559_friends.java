package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B26559_friends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            Map<Integer, String> map = new HashMap<>();
            for(int j = 0; j < m; j++) {
                String arr[] = br.readLine().split(" ");
                map.put(Integer.parseInt(arr[1]), arr[0]);
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            list.sort(Integer::compareTo);
            for(int j = m-1; j >= 0; j--) {
                if(j==0) {
                    System.out.println(map.get(list.get(j)));
                    break;
                }
                System.out.print(map.get(list.get(j)) + ", ");

            }
        }
        System.out.println();
    }
}
