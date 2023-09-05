package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char arr[] = new char[10];
        int count = 0;
        for(int i =0; i < s.length();i++) {
            arr[s.charAt(i) - 48]++;
        }
        int max = 0;

        arr[6] += arr[9];
        arr[6] = (char)Math.ceil((double)arr[6]/2);
        arr[9] = arr[6];

        for(int i =0; i < 10; i++){
            if(arr[i] > max) max = arr[i];
        }
        System.out.println(max);

    }
}
