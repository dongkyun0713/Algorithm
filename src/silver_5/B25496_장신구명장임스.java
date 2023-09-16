package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B25496_장신구명장임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        String input2[] = br.readLine().split(" ");
        int arr[] = new int[n];

        for(int i =0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);
        int count = 0;
        if(p == 200 ) System.out.println(0);
        else {
        for(int i = 0; i < n; i++) {
            p+= arr[i];
            count++;
            if(p >= 200) break;

        }
        System.out.println(count);
        }
    }
}
