package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("-");

        List<Integer> list = new ArrayList<>();
        for (String part : parts) {
            if (part.contains("+")) {
                String[] temp = part.split("\\+");
                int sum = 0;
                for (String t : temp) {
                    sum += Integer.parseInt(t);
                }
                list.add(sum);
            } else {
                list.add(Integer.parseInt(part));
            }
        }

        int answer = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }
        System.out.println(answer);
    }
}
