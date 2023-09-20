package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        Set<String> setA = new HashSet<>();
        String input2[] = br.readLine().split(" ");
        for(int i = 0; i < a; i++) {
            setA.add(input2[i]);
        }
        String input3[] = br.readLine().split(" ");
        for(int i = 0; i < b; i++) {
            setA.add(input3[i]);
        }
        int count = input2.length + input3.length - setA.size();
        System.out.println((input2.length - count) + (input3.length - count));

    }
}
