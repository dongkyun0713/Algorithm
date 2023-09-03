package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        while(true){
            String input[] = br.readLine().split(" ");
            arr[0] = Integer.parseInt(input[0]);
            arr[1] = Integer.parseInt(input[1]);
            arr[2] = Integer.parseInt(input[2]);
            Arrays.sort(arr);
            if(arr[0]==0 && arr[1]==0 && arr[2]==0) break;
            if(arr[2] >= arr[0] + arr[1]) System.out.println("Invalid");
            else if (arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
            else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}
