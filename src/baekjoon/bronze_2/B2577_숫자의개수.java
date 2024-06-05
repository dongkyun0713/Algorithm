package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());
        long mul = a * b * c;
        String s = String.valueOf(mul);

        for(int i = 0; i < 10; i++){
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(Integer.parseInt(String.valueOf(s.charAt(j))) == i ) count++;
            }
            System.out.println(count);
        }
    }
}
