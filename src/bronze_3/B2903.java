package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2903 {  // 중앙 이동 알고리즘 https://www.acmicpc.net/problem/2903
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = (int) Math.pow(Math.pow(2,N)+1,2);
        System.out.println(answer);
    }
}
