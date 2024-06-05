package baekjoon.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 2; i <= N; i++){
            if(N % i ==0) {
                if (i == 2) {
                    list.add(2);
                    continue;
                }
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) break;
                    if (j == i - 1) list.add(i);
                }
            }
        }

        for (int i = 0; i < list.size();i++){
            if(N / list.get(i) == 1 && N % list.get(i) == 0) {
                System.out.println(list.get(i));
                break;
            }
            if(N % list.get(i) == 0) {
                System.out.println(list.get(i));
                N /= list.get(i);
                i--;
            }
        }

    }
}
