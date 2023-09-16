package 보류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        String board[] = new String[row];
        int sol = Integer.MAX_VALUE;

        for(int i = 0; i < row - 8; i++) {
            for(int j = 0; j < col - 8; j++) {

            }
        }
    }
}
