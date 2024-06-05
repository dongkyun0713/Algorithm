package baekjoon.silver_3;


import java.io.*;

public class B9657_돌게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = N%7;
        if(answer==2||answer==0){
            System.out.println("CY");
        }
        else System.out.println("SK");
    }
}

