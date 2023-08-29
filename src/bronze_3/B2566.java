package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int max = 0;
        int row = 0;
        int column = 0;

        for(int i =1; i <= 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =1; j <= 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(max <= n){
                    max = n;
                    row = i;
                    column = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
