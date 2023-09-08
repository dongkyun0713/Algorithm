package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1059_좋은구간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int arr[] = new int[L+2];
        arr[0] = 0;
        arr[L+1] = 1001;
        for(int i = 0; i < L; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < L; i++) {

            int a = arr[i];
            int b = arr[i+1];
            if(n > a && n < b) {
                for (int j = a+1; j < b; j++) {
                    if(j > n) break;
                    for(int k = j +1; k < b; k++) {
                        if(k < n) continue;
                        count++;
                    }
                }
            }

        }
        System.out.println(count);
    }
}
