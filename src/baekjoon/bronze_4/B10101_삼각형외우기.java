package baekjoon.bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10101_삼각형외우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a + b+ c;
        if(a == 60 && b == 60 && c == 60) System.out.println("Equilateral");
        else if(sum == 180 && (a==b || b ==c || a==c)) System.out.println("Isosceles");
        else if(sum == 180) System.out.println("Scalene");
        else System.out.println("Error");
    }
}
