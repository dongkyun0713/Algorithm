package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B14215_세막대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int arr[] = new int[3];
        arr[0] = Integer.parseInt(input[0]);
        arr[1] = Integer.parseInt(input[1]);
        arr[2] = Integer.parseInt(input[2]);
        Arrays.sort(arr);

        if(arr[2] >= arr[0] + arr[1]) {
            arr[2] = arr[0] + arr[1] -1;
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
        else {
            System.out.println(arr[0] + arr[1] + arr[2]);
        }
    }
}
