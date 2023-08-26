package level_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[][] = new char[5][15];
        int max = 0;
        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            if(s.length() > max) max = s.length();

            for(int j =0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[j][i] == '\0') continue;  // char 배열의 초기값은 '\0'
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }
}
