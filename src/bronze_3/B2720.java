package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int C = Integer.parseInt(br.readLine());

            sb.append(C/25 + " ");
            C %= 25;
            sb.append(C/10 + " ");
            C %= 10;
            sb.append(C/5 + " ");
            C %= 5;
            sb.append(C/1 + "\n");
        }
        System.out.println(sb);
    }
}