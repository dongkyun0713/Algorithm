package bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B30033_Rust_Study {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        String input2[] = br.readLine().split(" ");
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(Integer.parseInt(input[i]) <= Integer.parseInt(input2[i])) count++;
        }
        System.out.println(count);
    }
}
