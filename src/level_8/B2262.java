package level_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 벌집
// https://www.acmicpc.net/problem/2292
public class B2262 {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int x = 1;
        if(N == 1) System.out.println(1);
        else {
            for (int i = 0; x < N; i += 6) {  // 0 6 12 18
                x += i;  // 1 7 19 37
                count++;
            }
            System.out.println(count);
        }

    }
}
