package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1075_나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int f = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(s.length()-2)).append(s.charAt(s.length()-1));
        int n = Integer.parseInt(s);
        int a = Integer.parseInt(String.valueOf(sb));
        n -= a;
        int answer = 0;

        for(int i = 0; i < 99; i++) {
            if((n+i) % f == 0) {
                answer = i;
                break;
            }
        }
        if(answer < 10) System.out.println(0+""+answer);
        else System.out.println(answer);
    }
}
