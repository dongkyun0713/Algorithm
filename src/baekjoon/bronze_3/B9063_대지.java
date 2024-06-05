package baekjoon.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9063_대지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max_x = -10001;
        int min_x = 10001;
        int max_y = -10001;
        int min_y = 10001;
        for(int i =0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if(min_x > x) min_x = x;
            if(min_y > y) min_y = y;
            if(max_x < x) max_x = x;
            if(max_y < y) max_y = y;
        }

        int area = (max_x - min_x) * (max_y - min_y);
        System.out.println(area);
    }
}
