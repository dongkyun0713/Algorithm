package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int count = 0;

        for (int i = 1; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > max){
                max = n;
                count = i;
            }

        }
        System.out.println(max);
        System.out.print(count);
    }
}
