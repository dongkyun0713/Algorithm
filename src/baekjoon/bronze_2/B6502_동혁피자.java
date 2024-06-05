package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6502_동혁피자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            String input[] = br.readLine().split(" ");
            int r = 2 * Integer.parseInt(input[0]);
            if(r==0) break;
            double w = Double.parseDouble(input[1]);
            double l = Double.parseDouble(input[2]);
            double d =  Math.sqrt(Math.pow(w,2) + Math.pow(l,2));

            if(r < d) {
                sb.append("Pizza ").append(++count).append(" does not fit on the table.").append("\n");
            }
            else  {
                sb.append("Pizza ").append(++count).append(" fits on the table.").append("\n");
            }
        }
        System.out.print(sb);
    }
}
