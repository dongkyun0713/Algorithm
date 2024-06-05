package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cross_count =1, prev_count_sum = 0;  // 대각선 칸 개수, 이전 대각선의 누적 합

        while(true) {
            if(X <= cross_count + prev_count_sum){
                if(cross_count % 2 ==1) {
                    int numerator = cross_count - (X - prev_count_sum - 1);  // 분자
                    int denominator = X - prev_count_sum;

                    System.out.println(numerator + "/" +  denominator);  // 분모
                    break;
                }
                else {
                    int numerator = X - prev_count_sum;
                    int denominator = cross_count - (X - prev_count_sum - 1);
                    System.out.println(numerator + "/" +  denominator);
                    break;
                }
            }
            else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        }

    }
}
