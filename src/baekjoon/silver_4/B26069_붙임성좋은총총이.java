package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B26069_붙임성좋은총총이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        while (n-- > 0) {
            String name[] = br.readLine().split(" ");
            if(set.contains(name[0]) || set.contains(name[1])) {
                set.add(name[0]);
                set.add(name[1]);
            }
        }
        System.out.println(set.size());
    }
}
