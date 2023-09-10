package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1181_단어정렬_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        int min = 50;
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();

        }
        Arrays.sort(arr);

        for(int i =0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }
}
