package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B24313_알고리즘수업_점근적표기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int a1 = Integer.parseInt(input[0]);
        int a0 = Integer.parseInt(input[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int result =  (a1 * n0 + a0 <= c * n0) && (c >= a1) ? 1 : 0;
        System.out.println(result);
    }
}
