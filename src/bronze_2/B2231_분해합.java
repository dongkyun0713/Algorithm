package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 1; i < n; i++){
            int x = (int) Math.pow(10, (int)( Math.log10(i)+1 ));
            sum += i;
            for(int j = 0; j < x; j++){
                sum += i % (int) Math.pow(10, j);
            }
            if(sum == n) break;
        }
    }
}
