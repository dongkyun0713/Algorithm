package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        for(int i = N; i >= M; i--) {
            if(i==1) continue;
            if(i==2) {
                sum +=2;
                min = 2;
                continue;
            }
            for(int j = 2; j < i; j++) {
                if(i % j ==0) break;
                if(j == i-1){
                    sum+= i;
                    min = i;
                }
            }
        }
        if(sum == 0) System.out.print(-1);
        else {
            System.out.println(sum);
            System.out.print(min);
        }
    }
}
