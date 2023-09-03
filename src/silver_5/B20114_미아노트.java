package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20114_미아노트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        int W = Integer.parseInt(input[2]);
        char arr[] = new char[N];
        for(int i = 0; i < H; i++) {
            String s = br.readLine();
            int a = 0;
            for(int j =0; j<s.length();j+=W){
                String s2;
                s2 = s.substring(j,j+W);
                for(int k = 0; k < s2.length(); k++){
                    if(s2.charAt(k) != '?') arr[a] = s2.charAt(k);
                }
                a++;
            }
        }
        for(int i = 0; i < N; i++) {
            if(arr[i] == 0) System.out.print('?');
            else System.out.print(arr[i]);
        }
    }
}
