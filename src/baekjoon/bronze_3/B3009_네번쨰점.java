package baekjoon.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3009_네번쨰점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1[] = br.readLine().split(" ");
        String input2[] = br.readLine().split(" ");
        String input3[] = br.readLine().split(" ");

        String x = "";
        String y = "";
        if(input1[0].equals(input2[0])) x = input3[0];
        else if(input1[0].equals(input3[0])) x = input2[0];
        else if(input2[0].equals(input3[0])) x = input1[0];

        if(input1[1].equals(input2[1])) y = input3[1];
        else if(input1[1].equals(input3[1])) y = input2[1];
        else if(input2[1].equals(input3[1])) y = input1[1];

        System.out.println(x + " " + y);
    }
}
