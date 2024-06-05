package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1235_학생번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num[] = new String[n];

        for(int i = 0; i < n; i++){
            num[i] = br.readLine();
        }
        int answer = 1;

        for(int i = 1; i < num[0].length(); i++) {
            String s[] = new String[n];
            for(int j = 0; j < n; j++){

                s[j] = num[j].substring(num[0].length()-i, num[0].length());

                }
            boolean b = true;
            for(int k = 0; k < n; k++){
                for(int a = k+1; a < n; a++){
                    if(s[k].equals(s[a])) b = false;
                }
            }
            if(!b) answer++;
            else break;
            }
        System.out.println(answer);
    }
}
