package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B5568_카드놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n-k + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i));
            for(int j = i+1; j < i + k ; j++) {
                System.out.println(j);
                sb.append(list.get(j));
                set.add(String.valueOf(sb));
            }

        }
        System.out.println();
    }
}
