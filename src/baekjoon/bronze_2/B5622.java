package baekjoon.bronze_2;

import java.io.*;
public class B5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'C')
                n += 3;
            else if(s.charAt(i) >= 'D' && s.charAt(i) <= 'F')
                n += 4;
            else if(s.charAt(i) >= 'G' && s.charAt(i) <= 'I')
                n += 5;
            else if(s.charAt(i) >= 'J' && s.charAt(i) <= 'L')
                n += 6;
            else if(s.charAt(i) >= 'M' && s.charAt(i) <= 'O')
                n += 7;
            else if(s.charAt(i) >= 'P' && s.charAt(i) <= 'S')
                n += 8;
            else if(s.charAt(i) >= 'T' && s.charAt(i) <= 'V')
                n += 9;
            else
                n+= 10;
        }
        System.out.println(n);
    }
}
