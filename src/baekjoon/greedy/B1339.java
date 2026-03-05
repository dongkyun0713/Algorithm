package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Map<Character, Integer> weight = new HashMap<>();
        for (String word : arr) {
            int p = 1;
            for (int i = word.length() - 1; i >= 0 ; i--) {
                char c = word.charAt(i);
                weight.put(c, weight.getOrDefault(c, 0) + p);
                p *= 10;
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(weight.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> map = new HashMap<>();
        int value = 9;
        for (Map.Entry<Character, Integer> e : list) {
            map.put(e.getKey(), value--);
        }
        long answer = 0;
        for (String word : arr) {
            long num = 0;
            for (int i = 0; i < word.length(); i++) {
                num = num * 10 + map.get(word.charAt(i));
            }
            answer+=num;
        }
        System.out.println(answer);
    }
}
