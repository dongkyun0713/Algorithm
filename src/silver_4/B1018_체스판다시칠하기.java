package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] chess = new char[n][m];

        for(int i = 0; i < n; i++){
            String input2 = br.readLine();
            for(int j = 0; j <  m; j++){
                chess[i][j] = input2.charAt(j);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m-1; j++){
                if(chess[i][j] != chess[i][j+1]) continue;
                else {
                    count++;
                }
            }
        }

    }
}
