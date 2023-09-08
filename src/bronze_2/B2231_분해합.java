package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int answer = 0;
            for (int i = 0; i < n; i++) {
                answer = i;
                sum = i;
                for(;i > 0;i /= 10){
                    sum += n%10;
                }
                if (sum == n) break;
                answer = 0;
            }

        System.out.println(answer);
    }
}
