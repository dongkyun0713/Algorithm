package baekjoon.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();

        while(true) {
            if(n / b ==0) {
                char c = (char) (n % b);
                if(c >= 10) c+= 55;
                else c+= 48;
                sb.insert(0 , c);
                break;
            }
            char c = (char) (n % b);
            if(c >= 10) c+= 55;
            else c+= 48;
            sb.insert(0, c);
            n /= b;
        }
        System.out.println(sb);
    }
}
