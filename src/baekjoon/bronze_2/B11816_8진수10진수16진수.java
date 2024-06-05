package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11816_8진수10진수16진수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        if(num.charAt(0) != '0') { // 10진수 일때
            System.out.print(num);
        }else if(num.charAt(1) != 'x') { //8진수 일때
            System.out.print(Integer.valueOf(Integer.parseInt(num.substring(1), 8)));
        }else { // 16 진수 일때
            System.out.print(Integer.valueOf(Integer.parseInt(num.substring(2), 16)));
        }
    }
}
