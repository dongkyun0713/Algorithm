package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B24264_알고리즘의수행시간3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        System.out.println(n * n);
        System.out.println(2);
    }
}
