package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }
        int m = Integer.parseInt(br.readLine());
        String input2[] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            if(set.contains(Integer.parseInt(input2[i]))) sb.append("1");
            else sb.append("0");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
