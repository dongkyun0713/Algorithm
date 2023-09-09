package gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B661_돌게임7_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if(n%3 == 2) System.out.println("CY");
        else System.out.println("SK");
    }
}
