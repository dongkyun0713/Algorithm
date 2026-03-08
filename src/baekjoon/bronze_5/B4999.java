package baekjoon.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String j = br.readLine();
        String d = br.readLine();
        System.out.println(j.length() >= d.length() ? "go" : "no");
    }
}
