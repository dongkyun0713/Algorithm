package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B19532_수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        int e = Integer.parseInt(input[4]);
        int f = Integer.parseInt(input[5]);


        for(int i = -999; i <= 999; i++){
            for(int j = -999; j <= 999; j++){
                if((a * i) + (b * j) == c && (d * i) + (e * j) == f) {
                    System.out.print(i + " " + j);
                    break;
                }
            }
        }

    }
}
